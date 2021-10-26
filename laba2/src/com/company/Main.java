/*
Вариант 8
Проверить, надежно ли составлен пароль. Пароль считается надежным,
если он состоит из 8 или более символов. Где символом может быть
английская буква, цифра и знак подчеркивания. Пароль должен
содержать хотя бы одну заглавную букву, одну маленькую букву и
одну цифру.
*/

package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // (\d+|\w[a-z] | \w[A-z]+){8,}
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*_).{8,}";
        Scanner in = new Scanner(System.in);
        boolean isCorrect = Pattern.matches(pattern, in.next());
        String result = isCorrect ? "correct" : "wrong";
        System.out.println(result);
    }
}
