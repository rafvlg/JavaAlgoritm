package Seminar1;
//Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
//Считаем, что 1 и 2 значения последовательности равны 1.
//Искать будем по формуле On=On-1+On-2 что предполагает использовать рекурсивного алгоритма.   

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) throws Exception {
        // Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N.
        Scanner iScan = new Scanner(System.in);
        int n = iScan.nextInt();
        iScan.close();

        System.out.println(fiboRecursion(n));
    }

    /**
     * @apiNote Algorithm of Fibonacci by recursion
     * @param pos - position to find
     * @return value of the element
     */
    public static int fiboRecursion(int pos) {
        if (pos == 1 || pos == 2) {
            return 1;
        }

        return fiboRecursion(pos - 1) + fiboRecursion(pos - 2);
    }
}
