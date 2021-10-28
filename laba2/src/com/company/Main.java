/*
Вариант 8
Проверить, надежно ли составлен пароль. Пароль считается надежным,
если он состоит из 8 или более символов. Где символом может быть
английская буква, цифра и знак подчеркивания. Пароль должен
содержать хотя бы одну заглавную букву, одну маленькую букву и
одну цифру.
*/

package com.company;

import javax.sound.midi.Soundbank;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    // сообщение о результате проверки ввода на соотвествие паттерну
    static String getPasswordReliability(String pattern, String userInput){
        return complianceCheck(pattern, userInput) ? "пароль надежный" : "пароль не надежный";
    }
    // получение пользовательского ввода
    static String getUserInput(){
        System.out.print("Введите пароль для анализа ");
        Scanner in = new Scanner(System.in);
        return in.next();
    }
    // проверяет соответствии userInput паттерну регулярного выражения pattern
    static boolean complianceCheck(String pattern, String userInput){
        return Pattern.matches(pattern, userInput);
    }
    public static void main(String[] args) {
        System.out.println("Приложение проверяет надежность набранного пароля ");
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*_).{8,}";
        String input = getUserInput();
        while(!input.equals("выход")) {
            System.out.println(getPasswordReliability(pattern, input));
            System.out.println("Для выхода напишите выход");
            input = getUserInput();
        }
    }
}
