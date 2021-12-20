package com.company;

import java.util.Scanner;

public class Main {

    static void out() {
        System.out.println("1 - определить команду с самым большим количеством побед");
        System.out.println("2 - определить команды с количеством побед выше среднего");
        System.out.println("3 - упорядочить массив по убыванию мест в лиге");
        System.out.println("4 - организовать поиск по названию команды, исправление одного из полей и вывод информации о команде");
        System.out.println("0 - выход");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Приветсвуем. Вы зашли в мендежер футбольной российской лиги");
        System.out.println("Для начала введите количество команд в лиге");

        RussianLeague russianLeague = new RussianLeague(3);

        russianLeague.AddTeamToLeague(new RussianFootballTeam("Спартак", "Москва", "Тренер1", 2, 1, 15));
        russianLeague.AddTeamToLeague(new RussianFootballTeam("ЦСКА", "Москва", "Тренер2", 1, 1, 20));
        russianLeague.AddTeamToLeague(new RussianFootballTeam("Зенит", "СПБ", "Тренер3", 3, 1, 10));


        while (true) {
            out();
            switch (in.nextInt()) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println(russianLeague.FindTeamWithTheMostVictoryAmount());
                    break;
                case 2:
                    System.out.println(russianLeague.FindTeamVictoryAmountMoreAverage());
                    break;
                case 3:
                    russianLeague.Sort();
                    System.out.println("команды отсортированы");
                    break;
                case 4:
                    System.out.println("Введите название команды");
                    String t = in.next();
                    if (russianLeague.FindTeam(t) != null) {
                        System.out.println("запись найдена");

                        try {
                            int n = in.nextInt();
                            russianLeague.changePlaceInLegue(t, n);
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
