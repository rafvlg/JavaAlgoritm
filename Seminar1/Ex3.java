package Seminar1;

import java.util.Scanner;

//Необходимо написать алгоритм поиска всех доступных комбинаций (посчитать количество) для 4 кубиков с количеством граней N.
//Данное решение имеет сложность O(n4), но если количество кубиков сделать переменной, то она трансформируется в O(nk), что будет представлять собой экспоненциальную сложность.
public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int facet = scanner.nextInt();
        scanner.close();
        System.out.println(getCount(facet));
    }

    /**
     * Алгоритм поиска всех доступных комбинаций для 4 кубиков с количеством граней N.
     * @param facet - количество граней
     * @return - возвращаем счетчик
     */
    private static int getCount(int facet) {
        int count = 0;
        for (int i = 0; i < facet; i++) {
            for (int j = 0; j < facet; j++) {
                for (int k = 0; k < facet; k++) {
                    for (int l = 0; l < facet; l++) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
