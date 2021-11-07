package Exam_26_June_2021;

import java.util.Scanner;

public class P2_Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] arrayCommands = scanner.nextLine().split(",\\s+");
        String[][] matrix = readMatrix(scanner, size, size);
        int startRow = findFirstRow(matrix, size, size);
        int startCol = findFirstCol(matrix, size, size);
        int lengthPython = 1;
        boolean isDead = false;
        int countFood = 0;
        for (String[] row : matrix) {
            for (String e : row) {
                if (e.equals("f")) {
                    countFood++;
                }
            }
        }
        for (int i = 0; i < arrayCommands.length; i++) {
            String currentCommand = arrayCommands[i];
            switch (currentCommand) {
                case "up":
                    startRow--;
                    startRow = getNewIndexRow(size, startRow);
                    if (matrix[startRow][startCol].equals("f")) {
                        lengthPython++;
                        countFood--;
                    } else if (matrix[startRow][startCol].equals("e")) {
                        isDead = true;
                        break;
                    }
                    break;
                case "down":
                    startRow++;
                    startRow = getNewIndexRow(size, startRow);
                    if (matrix[startRow][startCol].equals("f")) {
                        lengthPython++;
                        countFood--;
                    } else if (matrix[startRow][startCol].equals("e")) {
                        isDead = true;
                        break;
                    }
                    break;
                case "left":
                    startCol--;
                    startCol = getNewIndexCol(size, startCol);
                    if (matrix[startRow][startCol].equals("f")) {
                        lengthPython++;
                        countFood--;
                    } else if (matrix[startRow][startCol].equals("e")) {
                        isDead = true;
                        break;
                    }
                    break;
                case "right":
                    startCol++;
                    startCol = getNewIndexCol(size, startCol);
                    if (matrix[startRow][startCol].equals("f")) {
                        lengthPython++;
                        countFood--;
                    } else if (matrix[startRow][startCol].equals("e")) {
                        isDead = true;
                        break;
                    }
                    break;
            }
        }
        if (countFood == 0) {
            System.out.println("You win! Final python length is " + lengthPython);
        } else {
            if (isDead) {
                System.out.println("You lose! Killed by an enemy!");
            } else {
                System.out.printf("You lose! There is still %d food to be eaten.\n", countFood);
            }
        }
    }

    private static String[][] readMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] array = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = array[col];
            }
        }
        return matrix;
    }

    private static int findFirstRow(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals("s")) {
                    return row;
                }
            }
        }
        return 0;
    }

    private static int findFirstCol(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals("s")) {
                    return col;
                }
            }
        }
        return 0;
    }

    private static int getNewIndexRow(int rows, int row) {
        if (row < 0) {
            return rows - 1;
        } else if (row >= rows) {
            return 0;
        }
        return row;
    }

    private static int getNewIndexCol(int cols, int col) {
        if (col < 0) {
            return cols - 1;
        } else if (col >= cols) {
            return 0;
        }
        return col;
    }
}
