package lesson2.hw;

import java.io.IOException;
import java.util.logging.*;

public class second {
    public static void printArrayInt(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.printf("%d, ", arr[i]);
        }
        System.out.print(arr[arr.length - 1]);
    }

    public static int[] listSort(int[] arr) {
        for (int k = 0; k < arr.length - 1; k++) {
            for (int i = 0; i < arr.length - (k + 1); i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(second.class.getName());
        FileHandler fh = new FileHandler("C:\\Java\\lesson2\\hw\\logger.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.info("Array:");
        int[] array = { 7, 5, 3, -9, 3, 64, 0, -3, 22, 33, 132, 44, 0, -123, -3 };
        printArrayInt(array);
        int[] newArr = listSort(array);
        System.out.printf("\n Отсортированный массив: \n");
        printArrayInt(newArr);
    }
}