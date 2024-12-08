/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package complexityanalysis;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class ComplexityAnalysis {

    public static double[] generateRandomArray(int size, double min, double max) {
        double[] array = new double[size];
        Random random = new Random(123);
        for (int i = 0; i < size; i++) {
            array[i] = min + (max - min) * random.nextDouble();
        }
        return array;
    }

    public static void bubbleSort(double[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(double[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void insertionSort(double[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            double key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static boolean isSorted(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the size of the array: ");
            int arraySize = scanner.nextInt();

            double[] randomArray = generateRandomArray(arraySize, 0.0, 1000.0);

            double[] bubbleArray = randomArray.clone();
            double[] selectionArray = randomArray.clone();
            double[] insertionArray = randomArray.clone();

            long startTime = System.nanoTime();
            bubbleSort(bubbleArray);
            long endTime = System.nanoTime();
            System.out.printf("Bubble Sort Time: %.3f ms%n", (endTime - startTime) / 1e6);

            startTime = System.nanoTime();
            selectionSort(selectionArray);
            endTime = System.nanoTime();
            System.out.printf("Selection Sort Time: %.3f ms%n", (endTime - startTime) / 1e6);

            startTime = System.nanoTime();
            insertionSort(insertionArray);
            endTime = System.nanoTime();
            System.out.printf("Insertion Sort Time: %.3f ms%n", (endTime - startTime) / 1e6);

            System.out.println("All arrays sorted correctly: " +
                    (isSorted(bubbleArray) && isSorted(selectionArray) && isSorted(insertionArray)));

            System.out.print("Do you want to test again? (yes/no): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }

        scanner.close();
    }
}
