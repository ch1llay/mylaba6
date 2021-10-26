package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // (\d+|\w[a-z] | \w[A-z]+){8,}
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9_]).{8,}";
        Scanner in = new Scanner(System.in);
        boolean isCorrect = Pattern.matches(pattern, in.next());
        String result = isCorrect ? "correct" : "wrong";
        System.out.println(result);
    }
}
