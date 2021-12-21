package com.company;

import java.util.Scanner;

public class Main {

    static void out() {
        System.out.println("1 - определить команду с самым большим количеством побед");
        System.out.println("2 - определить команды с количеством побед выше среднего");
        System.out.println("3 - упорядочить массив по убыванию мест в лиге");
        System.out.println("4 - поиск по названию команды, изменение бюджета команды в лиге с выводом на экран информации о команде");
        System.out.println("0 - выход");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        RussianLeague russianLeague = new RussianLeague(3);

        russianLeague.AddTeamToLeague(new RussianFootballTeam("ЦСКА", "Москва", "Алексей Березуцкий", 6, 5555, 20, "Игорь Акинфеев", "ВЭБ Арена", "Евгений Гинер", 1911));
        russianLeague.AddTeamToLeague(new RussianFootballTeam("Спартак", "Москва", "Паоло Ваноли", 2, 8600, 16, "Георгий Джикия", "Открытие Банк Арена", "Леонид Федун", 1922));
        russianLeague.AddTeamToLeague(new RussianFootballTeam("Зенит", "СПБ", "Сергей Семак", 1, 188, 25, "Деян Ловрен", "Газпром Арена", " ", 1925));
        russianLeague.AddTeamToLeague(new RussianFootballTeam("Томь", "Томск", "Сергей Жуков", 18, 400, 8, "Дмитрий Арапов", "Труд, Томск", "Сергей Жвачкин", 1957));
        russianLeague.AddTeamToLeague(new RussianFootballTeam("Ростов", "Ростов-на-Дону", "Виталий Кафанов", 9, 32, 10, "Данил Глебов", "Ростов Арена", "Арташес Арутюнянц",1930));

        int choice;
        while (true) {
            out();
            if(in.hasNextInt()){
                choice = in.nextInt();
            }
            else{
                in.next();
                System.out.println("Ошибка, введите число");
                continue;
            }
            System.out.println("*************************************");
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Команда с самым большим числом побед");
                    System.out.println(russianLeague.FindTeamWithTheMostVictoryAmount());
                    break;
                case 2:
                    System.out.println("Команды, количество побед которых выше среднего");
                    System.out.println(russianLeague.FindTeamVictoryAmountMoreAverage());
                    break;
                case 3:
                    russianLeague.Sort();
                    System.out.println("команды отсортированы");
                    System.out.println(russianLeague.teams);
                    break;
                case 4:
                    System.out.println("Введите название команды");
                    String teamName = in.next();
                    if (russianLeague.FindTeam(teamName) != null) {
                        System.out.println("запись найдена");
                        System.out.println("Введите новый бюджет команды (млн р.)");
                        try {
                            int n = in.nextInt();
                            russianLeague.changeBudgetTeam(teamName, n);
                            System.out.println(russianLeague.FindTeam(teamName));
                        } catch (Exception e) {
                            System.out.println("введите число");
                        }

                    } else {
                        System.out.println("такая команда не найдена");
                    }
                    break;


            }
        }
    }
}
