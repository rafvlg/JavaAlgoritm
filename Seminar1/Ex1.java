package Seminar1;

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = getSum(n);
        System.out.println("sum = " + sum);

    }

    /**
     * @param n число до которого необходимо ссуммировать
     * @return сумма
     * @apiNote Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N
     */
    private static int getSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
