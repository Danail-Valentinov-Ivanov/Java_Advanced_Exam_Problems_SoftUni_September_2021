package Retake_Exam_17_Dec_2019;

import java.util.Scanner;

public class P2_Present_Delivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfPresents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = readMatrix(scanner, size, size);
        int countNiceKidsBeginning = countNiceKids(matrix);
        int firstRow = findFirstRow(matrix, size, size);
        int firstCol = findFirstCol(matrix, size, size);
        matrix[firstRow][firstCol] = "-";
        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")) {
            switch (command) {
                case "up":
                    if (!isOutOfBounds(size, size, firstRow - 1, firstCol)) {
                        firstRow--;
                        if (matrix[firstRow][firstCol].equals("X")) {
                            matrix[firstRow][firstCol] = "-";
                        } else if (matrix[firstRow][firstCol].equals("V")) {
                            countOfPresents--;
                            matrix[firstRow][firstCol] = "-";
                        } else if (matrix[firstRow][firstCol].equals("C")) {
                            matrix[firstRow][firstCol] = "-";
                            countOfPresents = isGenerous(matrix, firstRow, firstCol, countOfPresents);
                        }
                    }
                    break;
                case "down":
                    if (!isOutOfBounds(size, size, firstRow + 1, firstCol)) {
                        firstRow++;
                        if (matrix[firstRow][firstCol].equals("X")) {
                            matrix[firstRow][firstCol] = "-";
                        } else if (matrix[firstRow][firstCol].equals("V")) {
                            countOfPresents--;
                            matrix[firstRow][firstCol] = "-";
                        } else if (matrix[firstRow][firstCol].equals("C")) {
                            matrix[firstRow][firstCol] = "-";
                            countOfPresents = isGenerous(matrix, firstRow, firstCol, countOfPresents);
                        }
                    }
                    break;
                case "left":
                    if (!isOutOfBounds(size, size, firstRow, firstCol - 1)) {
                        firstCol--;
                        if (matrix[firstRow][firstCol].equals("X")) {
                            matrix[firstRow][firstCol] = "-";
                        } else if (matrix[firstRow][firstCol].equals("V")) {
                            countOfPresents--;
                            matrix[firstRow][firstCol] = "-";
                        } else if (matrix[firstRow][firstCol].equals("C")) {
                            matrix[firstRow][firstCol] = "-";
                            countOfPresents = isGenerous(matrix, firstRow, firstCol, countOfPresents);
                        }
                    }
                    break;
                case "right":
                    if (!isOutOfBounds(size, size, firstRow, firstCol + 1)) {
                        firstCol++;
                        if (matrix[firstRow][firstCol].equals("X")) {
                            matrix[firstRow][firstCol] = "-";
                        } else if (matrix[firstRow][firstCol].equals("V")) {
                            countOfPresents--;
                            matrix[firstRow][firstCol] = "-";
                        } else if (matrix[firstRow][firstCol].equals("C")) {
                            matrix[firstRow][firstCol] = "-";
                            countOfPresents = isGenerous(matrix, firstRow, firstCol, countOfPresents);
                        }
                    }
                    break;
            }
            if (countOfPresents <= 0) {
                break;
            }
            command = scanner.nextLine();
        }
        int niceKidsWithoutPresent = countNiceKids(matrix);
        int niceKidsWithPresent = countNiceKidsBeginning - niceKidsWithoutPresent;
        matrix[firstRow][firstCol] = "S";
        if (countOfPresents <= 0) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrix);
        if (niceKidsWithoutPresent == 0) {
            System.out.println("Good job, Santa! " + niceKidsWithPresent + " happy nice kid/s.");
        } else {
            System.out.println("No presents for " + niceKidsWithoutPresent + " nice kid/s.");
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
                if (matrix[row][col].equals("S")) {
                    return row;
                }
            }
        }
        return 0;
    }

    private static int findFirstCol(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals("S")) {
                    return col;
                }
            }
        }
        return 0;
    }

    private static int isGenerous(String[][] matrix, int firstRow, int firstCol, int countOfPresents) {
        if (!matrix[firstRow - 1][firstCol].equals("-")) {
            countOfPresents--;
            matrix[firstRow - 1][firstCol] = "-";
        }
        if (!matrix[firstRow + 1][firstCol].equals("-")) {
            countOfPresents--;
            matrix[firstRow + 1][firstCol] = "-";
        }
        if (!matrix[firstRow][firstCol - 1].equals("-")) {
            countOfPresents--;
            matrix[firstRow][firstCol - 1] = "-";
        }
        if (!matrix[firstRow][firstCol + 1].equals("-")) {
            countOfPresents--;
            matrix[firstRow][firstCol + 1] = "-";
        }
        return countOfPresents;
    }

    private static boolean isOutOfBounds(int rows, int cols, int row, int col) {
        if (row < 0 || row >= rows) {
            if (col < 0 || col >= cols) {
                return true;
            }
        }
        return false;
    }

    private static int countNiceKids(String[][] matrix) {
        int count = 0;
        for (String[] row : matrix) {
            for (String kid : row) {
                if (kid.equals("V")) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
