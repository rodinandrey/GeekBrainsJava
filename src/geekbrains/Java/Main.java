package geekbrains.Java;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static int HUMAN = 1;
    private final static int MACHINE = 2;
    private final static String DEFAULTCHAR = "*";
    private final static String X = "X";
    private final static String O = "O";



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 5; // размер поля
        int winLineLength = 3; // длинна выигрышной линии
        String[][] map = createMap(size);
        int [][][] winnerVariants = findWinnerVariants(map, winLineLength);
        // showWinnerVariants(map, winnerVariants);
        int steps = size*size;
        int currentPlayer;
        boolean end_game = false;
        int first_step = firstStep();
        do{
            currentPlayer = (first_step == HUMAN && steps%2 != 0 || first_step == MACHINE && steps%2 == 0 ) ? HUMAN : MACHINE;
            printMap(map);
            if(currentPlayer == HUMAN){
                int a[] = humanMove(sc, map);
                map = addMap(map, a, X);
            } else {
                int a[] = machineMove(map, winnerVariants);
                //map = addMap(map, a, O);
            }
            steps--;
            end_game = checkEndGame(map, steps, currentPlayer, winnerVariants);
        }
        while (!end_game);
    }

    // Массив всех выигрышных вариантов
    public static int[][][] findWinnerVariants(String[][] map, int lineLength) {
        int size = map.length;
        int straightLineCounts = 2 * size * (size - lineLength + 1); // Количество выигрышных вариантов по горизонтали и вертикали
        int diagLineCounts = 2 * (int) Math.pow(size - lineLength + 1, 2); // Количество выигрышных вариантов по диагоналям
        int winVariantsCount = straightLineCounts + diagLineCounts; // Общее количество выигрышных вариантов
        int[][][] variants = new int [winVariantsCount][lineLength][2];
        variants = findStraightLineVariants(variants, map, lineLength, 0);
        variants = findDiagLineVariants(variants, map, lineLength, straightLineCounts);
        return variants;
    }

    // Искать все выигрышные варианты по горизонтали и вертикали
    public static int[][][] findStraightLineVariants(int[][][]variants, String[][] map, int lineLength, int startPos) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <= map[i].length - lineLength; j++) {
                int aa = 0;
                for (int k = j; k < j + lineLength; k++) {
                    variants[startPos][aa][0] = i;
                    variants[startPos][aa][1] = k;
                    variants[startPos + 1][aa][0] = k;
                    variants[startPos + 1][aa][1] = i;
                    aa++;
                }
                startPos += 2;
            }
        }
        return variants;
    }

    // Показать все выигрышные варианты на экране
    public static void showWinnerVariants(String[][] map, int[][][]variants){
        for(int[][] variant: variants) {
            String[][] variantMap = createMap(map.length);
            for(int[] xy: variant) {
                variantMap = addMap(variantMap, xy, X);
            }
            printMap(variantMap);
            System.out.println();
        }
    }

    // Искать все выигрышные варианты по диагонали
    public static int[][][] findDiagLineVariants(int[][][]variants, String[][] map, int lineLength, int startPos) {
        int mapLength = map.length;
        for (int i = 0; i < mapLength - lineLength + 1; i++) {
            for (int j = 0; j <= mapLength - lineLength; j++) {
                int aa = 0;
                for (int k = 0; k < lineLength; k++) {
                    variants[startPos][aa][0] = i + k;
                    variants[startPos][aa][1] = k+j;
                    variants[startPos + 1][aa][0] = mapLength - k - i - 1;
                    variants[startPos + 1][aa][1] = k+j;
                    aa++;
                }
                startPos += 2;
            }
        }
        return variants;
    }

    // Добавляем точку на карту
    public static String[][] addMap(String[][] map, int[]a, String ch) {
        int x = a[0]; int y = a[1];
        map[x][y] = ch;
        return map;
    }

    // вывод карты
    public static void printMap(String[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    //  проверка конца игры
    public static boolean checkEndGame(String[][] map, int steps, int currentPlayer, int [][][] winnerVariants){
        boolean win = checkWinner(map, currentPlayer, winnerVariants);
        if(win == true ){
            System.out.println((currentPlayer == HUMAN) ? "Человек выиграл" : "Машина выиграла");
        }
        if(win == true || steps == 0){
            return true;
        }
        return false;
    }

    // проверка победителя
    public static boolean checkWinner(String[][] map, int currentPlayer, int [][][] winnerVariants){
        String ch = (currentPlayer == HUMAN) ? X : O;
        for (int[][] variant: winnerVariants){
            boolean win = true;
            for(int[]xy: variant){
                int x = xy[0];
                int y = xy[1];
                if(map[x][y] != ch){
                    win = false;
                }
            }
            if(win) return true;
        }
        return false;
    }

    // ход машины
    public static int[] machineMove(String[][] map, int [][][] winnerVariants){
        System.out.println("Ход машины");
        // TO DO
        // Не хватило времени
        // Ищем возможные выигрышные варианты, где машине не хватает хода.
        // Если таких нет, ищем выигрышные варианты человека, где ему не хватает одного хода и блокируем
        // Если нет таких ищем возможные выигрышные варианты машины, сортируем по количеству оставшихся ходов. Берем первый, где количество ходов минимально
        int[] xy = new int[2];
        return xy;
    }

    // ход человека
    public static int[] humanMove(Scanner sc, String[][]map){
        System.out.println("Ход человека");
        System.out.println("Укажите координаты клетки, указав координаты X и Y от 1 до "+map.length+". Например: '1 1'");
        do {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            if(x > (map.length - 1) || y > (map.length - 1)) {
                System.out.println("Указанная клетка находится вне поля. Повторите ввод");
            } else if(map[x][y] == DEFAULTCHAR) {
                int[] a = {x, y};
                return a;
            } else {
                System.out.println("Указанная клетка уже занята. Повторите ввод");
            }
        } while(true);
    }

    // инициализация карты
    public static String[][] createMap(int size){
        String[][] map = new String[size][size];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DEFAULTCHAR;
            }
        }
        return map;
    }

    // случайная жеребьевка
    public static int firstStep(){
        Random rnd = new Random();
        return rnd.nextInt(2) + 1;
    }
}
