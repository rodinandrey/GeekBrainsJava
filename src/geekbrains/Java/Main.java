package geekbrains.Java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // taskOne(3);
        taskTwo();
    }

    public static void taskOne(int max_count){
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        boolean end_game = false;
        int random = (int) (Math.random() * 9);
        while(end_game == false){
            cnt++;
            System.out.println("Введите число:");
            int number = sc.nextInt();
            if(number > random){
                System.out.println("Введенное число больше загаданного");
            } else if(number < random) {
                System.out.println("Введенное число меньше загаданного");
            } else {
                System.out.println("Вы выиграли!!!");
                end_game = true;
            }
            if(cnt == max_count){
                if(end_game == false) System.out.println("Вы проиграли (((");
                end_game = true;
            }
        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)");
        int repeat = sc.nextInt();
        if(repeat == 1) taskOne(max_count); else System.out.println("Спасибо за игру");
    }

    public static void taskTwo(){
        Scanner sc = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "result", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int random = (int) (Math.random() * (words.length -1));
        String word = words[random];
        boolean end_game = false;
        int cnt = 0;
        while(end_game == false) {
            cnt++;
            System.out.println("Введите слово:");
            String user_word = sc.nextLine().toLowerCase();
            int min_lenght = (user_word.length() > word.length()) ? word.length() : user_word.length();
            String result = "";
            end_game = user_word.length() == word.length() ? true : false;
            for (int i = 0; i < min_lenght; i++) {
                if(user_word.charAt(i) == word.charAt(i)){
                    result += user_word.charAt(i);
                } else {
                    result += "#";
                    end_game = false;
                }
            }
            if (end_game == false){
                if (result.length() < 15){
                    System.out.println(result + "#".repeat(15 - result.length()));
                }
            } else {
                System.out.println("Вы угадали слово " + word + ". Попыток: " + cnt);
            }
        }
    }
}
