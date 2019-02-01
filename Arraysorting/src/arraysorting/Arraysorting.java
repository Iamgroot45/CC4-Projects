package arraysorting;

import java.util.Scanner;

public class Arraysorting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int[] array = new int[10];
        
        System.out.println("Input 10 Integers");
        for (int i = 0; i < 10; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("\nUNSORTED");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nSORTED");

        bubbleSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
