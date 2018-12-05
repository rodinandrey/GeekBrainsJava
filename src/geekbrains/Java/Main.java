package geekbrains.Java;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        // Задание 1
        int[] arr1 = {1,1,0,0,1,0,1,1,0,0};
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (arr1[i] == 0) ? 1 : 0;
        }
        System.out.println(Arrays.toString(arr1));

        System.out.println("Задание 2");
        // Задание 2
        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i*3;
        }
        System.out.println(Arrays.toString(arr2));

        System.out.println("Задание 3");
        // Задание 3
        int[] arr3 = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i = 0; i < arr1.length; i++) {
            if(arr3[i] < 6){
                arr3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr3));

        System.out.println("Задание 4 Вариант 1");
        // Задание 4 Вариант 1
        int[][] arr4 = new int[10][10];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                arr4[i][j] = (i == j) ? 1 : 0;
            }
        }
        System.out.println(Arrays.deepToString(arr4));
        System.out.println("Задание 4 Вариант 2");
        // Задание 4 Вариант 2
        int[][] arr41 = new int[10][10];
        for (int i = 0; i < arr41.length; i++) {
            arr41[i][i] = 1;
        }
        System.out.println(Arrays.deepToString(arr41));

        // Задание 5
        System.out.println("Задание 5");
        int[] min_max_arr1 = {1,5,3,2,11,4,5,2,4,8,9,1};
        minMax(min_max_arr1);


        System.out.println("Задание 6");
        // Задание 6
        //int[] balance_arr1 = {10, 10}; //true 10
        //int[] balance_arr1 = {10, 1, 8, 3}; //true 11
        //int[] balance_arr1 = {10, 1, 8}; //false
        int[] balance_arr1 = {2, 1, 1, 2, 1}; //true 3 Странно, что в примере задания стоит false
        System.out.println(checkBalance(balance_arr1));

        System.out.println("Задание 7");
        // Задание 7
        int[] move_arr1 = {1,2,3,4,5,6,7,8,9,10}; // -3 {3,4,5,6,7,8,9,0,0,0}
        System.out.println(Arrays.toString(moveArray(move_arr1, -3)));
        int[] move_arr2 = {1,2,3,4,5,6,7,8,9,10}; // -3 {3,4,5,6,7,8,9,0,0,0}
        System.out.println(Arrays.toString(moveArray(move_arr2, 3)));

    }

    public static void minMax(int[] arr){
        int min = arr[0], max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
            }
            if(max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println("Минимальное число " + min + ", Максимальное число " + max);

    }

    public static boolean checkBalance(int[] arr){
        int sum_left = 0, sum_right;
        for (int i = 0; i < arr.length; i++) {
            sum_left += arr[i];
            sum_right = 0;
            for (int j = arr.length - 1; j > i; j--) {
                sum_right += arr[j];
                if(sum_right == sum_left){
                    // System.out.println("Сумма  " + sum_right);
                    return true;
                }
            }
        }
        return false;
    }



    public static int[] moveArray(int[] arr, int a){
        int pos;
        int length = arr.length;
        if(a < 0){
            for (int i = 0; i < length; i++) {
                pos = i - a;
                arr[i] = (pos < length) ? arr[pos] : 0 ;
            }
        } else if(a > 0) {
            for (int i = length - 1; i >= 0; i--) {
                pos = i - a;
                arr[i] = (i >= a) ? arr[pos] : 0 ;
            }
        }
        return arr;
    }
}
