package Seminar2;

import java.util.Arrays;

public class Ex4 {
public static void main(String[] args) {
        int size = 100;
        int min  = 1;
        int max = 100;
        int [] array = Ex1.getRandomArr(size, min, max);
        Arrays.sort(array);
        Ex1.printArr(array);
        System.out.println(search(array, 5, 0, array.length - 1));
    }
    public static int search(int [] array, int value, int min, int max) {
        int middle;
        if (max < min) {
            return -1;
        } else {
            middle = (max - min) / 2 + min;
        }
        if (array[middle] < value) {
            return search(array, value, middle + 1, max);
        } else {
            if (array[middle] > value) {
                return search(array,value, min, middle - 1);
            } else {
                return middle;
            }
        }
    }
}
