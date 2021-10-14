/*Вариант 8
Ввести с консоли t целых чисел и поместить их в массив. На консоль
вывести дробную часть десятичной дроби р = m/n для первых двух
целых положительных чисел n и m, расположенных подряд.*/


import java.util.Scanner;

public class Laba1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите t ");
        int t = in.nextInt();
        if (t >= 2) {
            float n = -1;
            float m = -1;
            float[] array = new float[t];
            for (int i = 0; i < t; i++) {
                float k = in.nextFloat();
                array[i] = k;
                if (k > 0) {
                    if (n == -1)
                        n = k;
                    else if (m == -1)
                        m = k;
                }
            }
            float p = m / n;
            float result = p - (int) p
            System.out.println(result);
        }
        else{
            System.out.println("Для работы программы нужно как минимум 2 числа");
        }
    }
}


