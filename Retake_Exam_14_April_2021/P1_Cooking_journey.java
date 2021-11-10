package Retake_Exam_14_April_2021;

import java.util.Scanner;

public class P1_Cooking_journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        Character[][] matrix = readMatrix(scanner, size, size);
        int currentRow = findStartRow(matrix, size, size);
        int currentCol = findStartCol(matrix, size, size);
        matrix[currentRow][currentCol] = '-';
        int pillar1Row = 0;
        int pillar1Col = 0;
        int pillar2Row = 0;
        int pillar2Col = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals('P')) {
                    if (pillar1Row == 0 && pillar1Col == 0) {
                        pillar1Row = row;
                        pillar1Col = col;
                    } else {
                        pillar2Row = row;
                        pillar2Col = col;
                    }
                }
            }
        }
        boolean isSucceeded = true;
        int sum = 0;
        while (sum < 50) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    currentRow--;
                    if (isValidIndexes(size, size, currentRow, currentCol)) {
                        if (Character.isDigit(matrix[currentRow][currentCol])) {
                            sum += Integer.parseInt(matrix[currentRow][currentCol].toString());
                            matrix[currentRow][currentCol] = '-';
                        } else if (matrix[currentRow][currentCol].equals('P')) {
                            matrix[pillar1Row][pillar1Col] = '-';
                            matrix[pillar2Row][pillar2Col] = '-';
                            if (currentRow == pillar1Row && currentCol == pillar1Col) {
                                currentRow = pillar2Row;
                                currentCol = pillar2Col;
                            } else {
                                currentRow = pillar1Row;
                                currentCol = pillar1Col;
                            }
                        }
                    } else {
                        isSucceeded = false;
                    }
                    break;
                case "down":
                    currentRow++;
                    if (isValidIndexes(size, size, currentRow, currentCol)) {
                        if (Character.isDigit(matrix[currentRow][currentCol])) {
                            sum += Integer.parseInt(matrix[currentRow][currentCol].toString());
                            matrix[currentRow][currentCol] = '-';
                        } else if (matrix[currentRow][currentCol].equals('P')) {
                            matrix[pillar1Row][pillar1Col] = '-';
                            matrix[pillar2Row][pillar2Col] = '-';
                            if (currentRow == pillar1Row && currentCol == pillar1Col) {
                                currentRow = pillar2Row;
                                currentCol = pillar2Col;
                            } else {
                                currentRow = pillar1Row;
                                currentCol = pillar1Col;
                            }
                        }
                    } else {
                        isSucceeded = false;
                    }
                    break;
                case "left":
                    currentCol--;
                    if (isValidIndexes(size, size, currentRow, currentCol)) {
                        if (Character.isDigit(matrix[currentRow][currentCol])) {
                            sum += Integer.parseInt(matrix[currentRow][currentCol].toString());
                            matrix[currentRow][currentCol] = '-';
                        } else if (matrix[currentRow][currentCol].equals('P')) {
                            matrix[pillar1Row][pillar1Col] = '-';
                            matrix[pillar2Row][pillar2Col] = '-';
                            if (currentRow == pillar1Row && currentCol == pillar1Col) {
                                currentRow = pillar2Row;
                                currentCol = pillar2Col;
                            } else {
                                currentRow = pillar1Row;
                                currentCol = pillar1Col;
                            }
                        }
                    } else {
                        isSucceeded = false;
                    }
                    break;
                case "right":
                    currentCol++;
                    if (isValidIndexes(size, size, currentRow, currentCol)) {
                        if (Character.isDigit(matrix[currentRow][currentCol])) {
                            sum += Integer.parseInt(matrix[currentRow][currentCol].toString());
                            matrix[currentRow][currentCol] = '-';
                        } else if (matrix[currentRow][currentCol].equals('P')) {
                            matrix[pillar1Row][pillar1Col] = '-';
                            matrix[pillar2Row][pillar2Col] = '-';
                            if (currentRow == pillar1Row && currentCol == pillar1Col) {
                                currentRow = pillar2Row;
                                currentCol = pillar2Col;
                            } else {
                                currentRow = pillar1Row;
                                currentCol = pillar1Col;
                            }
                        }
                    } else {
                        isSucceeded = false;
                    }
                    break;
            }
            if (!isSucceeded) {
                break;
            }
        }
        if (!isSucceeded) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
            matrix[currentRow][currentCol] = 'S';
        }
        System.out.println("Money: " + sum);
        printMatrix(matrix);
    }

    private static Character[][] readMatrix(Scanner scanner, int rows, int cols) {
        Character[][] matrix = new Character[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] array = scanner.nextLine().split("");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = array[col].charAt(0);
            }
        }
        return matrix;
    }

    private static int findStartRow(Character[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals('S')) {
                    return row;
                }
            }
        }
        return 0;
    }

    private static int findStartCol(Character[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals('S')) {
                    return col;
                }
            }
        }
        return 0;
    }

    private static boolean isValidIndexes(int rows, int cols, int row, int col) {
        if (row >= 0 && row < rows) {
            if (col >= 0 && col < cols) {
                return true;
            }
        }
        return false;
    }

    private static void printMatrix(Character[][] matrix) {
        for (Character[] row : matrix) {
            for (Character e : row) {
                System.out.print(e);
            }
            System.out.println();
        }
    }
}
