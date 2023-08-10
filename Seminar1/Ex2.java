package Seminar1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Написать алгоритм поиска простых чисел (делятся только на себя и на 1) в диапазоне от 1 до N.
//В алгоритме будет использоваться вложенный for, что явно говорит о квадратичной сложности
public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            boolean find = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0){
                    find = false;
                    break;
                }
            }
            if (find){
                result.add(i);
            }
        }
        System.out.println("result = " + result);
    }
}


