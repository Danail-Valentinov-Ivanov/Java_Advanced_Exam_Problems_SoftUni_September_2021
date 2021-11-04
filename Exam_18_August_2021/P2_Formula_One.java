package Exam_18_August_2021;

import java.util.Scanner;

public class P2_Formula_One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int numberCommands = Integer.parseInt(scanner.nextLine());
        int firstRow = 0;
        int firstCol = 0;
        String[][] matrix = new String[size][size];
        for (int i = 0; i < size; i++) {
            String[] array = scanner.nextLine().split("");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = array[j];
                if (matrix[i][j].equals("P")) {
                    firstRow = i;
                    firstCol = j;
                    matrix[i][j] = ".";
                }
            }
        }
        boolean isFinished = false;
        while (numberCommands-- > 0) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    int startRow = firstRow;
                    startRow--;
                    startRow = getFirstRow(startRow, size);
                    String currentValue = matrix[startRow][firstCol];
                    if (currentValue.equals("B")) {
                        startRow--;
                    } else if (currentValue.equals("T")) {
                        startRow++;
                    } else if (currentValue.equals("F")) {
                        isFinished = true;
                    }
                    firstRow = getFirstRow(startRow, size);
                    if (isFinished) {
                        break;
                    }
                    break;
                case "down":
                    startRow = firstRow;
                    startRow++;
                    startRow = getFirstRow(startRow, size);
                    currentValue = matrix[startRow][firstCol];
                    if (currentValue.equals("B")) {
                        startRow++;
                    } else if (currentValue.equals("T")) {
                        startRow--;
                    } else if (currentValue.equals("F")) {
                        isFinished = true;
                    }
                    firstRow = getFirstRow(startRow, size);
                    if (isFinished) {
                        break;
                    }
                    break;
                case "left":
                    int startCol = firstCol;
                    startCol--;
                    startCol = getFirstCol(startCol, size);
                    currentValue = matrix[firstRow][startCol];
                    if (currentValue.equals("B")) {
                        startCol--;
                    } else if (currentValue.equals("T")) {
                        startCol++;
                    } else if (currentValue.equals("F")) {
                        isFinished = true;
                    }
                    firstCol = getFirstCol(startCol, size);
                    if (isFinished) {
                        break;
                    }
                    break;
                case "right":
                    startCol = firstCol;
                    startCol++;
                    startCol = getFirstCol(startCol, size);
                    currentValue = matrix[firstRow][startCol];
                    if (currentValue.equals("B")) {
                        startCol++;
                    } else if (currentValue.equals("T")) {
                        startCol--;
                    } else if (currentValue.equals("F")) {
                        isFinished = true;
                    }
                    firstCol = getFirstCol(startCol, size);
                    if (isFinished) {
                        break;
                    }
                    break;
            }
        }
        matrix[firstRow][firstCol] = "P";
        if (isFinished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        for (int row = 0; row < size; row++) {
            for (String element : matrix[row]) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static int getFirstCol(int startCol, int size) {
        if (startCol < 0) {
            return size - 1;
        } else if (startCol >= size) {
            return 0;
        }
        return startCol;
    }

    private static int getFirstRow(int startRow, int size) {
        if (startRow < 0) {
            return size - 1;
        } else if (startRow >= size) {
            return 0;
        }
        return startRow;
    }
}
