package Exam_28_June_2020;

import java.util.Scanner;

public class P2_Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = readMatrix(scanner, size, size);
        int startRow = findFirstRow(matrix, size, size);
        int startCol = findFirstCol(matrix, size, size);
        int borrow1Row = 0;
        int borrow1Col = 0;
        int borrow2Row = 0;
        int borrow2Col = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("B")) {
                    if (borrow1Row == 0 && borrow1Col == 0) {
                        borrow1Row = row;
                        borrow1Col = col;
                    } else {
                        borrow2Row = row;
                        borrow2Col = col;
                    }
                }
            }
        }
        int foodQuantity = 0;
        boolean gameOver = false;
        while (foodQuantity < 10) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    matrix[startRow][startCol] = ".";
                    startRow--;
                    if (isValidIndexes(size, size, startRow, startCol)) {
                        if (matrix[startRow][startCol].equals("*")) {
                            foodQuantity++;
                        } else if (matrix[startRow][startCol].equals("B")) {
                            matrix[startRow][startCol] = ".";
                            if (startRow == borrow1Row && startCol == borrow1Col) {
                                startRow = borrow2Row;
                                startCol = borrow2Col;
                            } else {
                                startRow = borrow1Row;
                                startCol = borrow1Col;
                            }
                        }
                    } else {
                        gameOver = true;
                    }
                    break;
                case "down":
                    matrix[startRow][startCol] = ".";
                    startRow++;
                    if (isValidIndexes(size, size, startRow, startCol)) {
                        if (matrix[startRow][startCol].equals("*")) {
                            foodQuantity++;
                        } else if (matrix[startRow][startCol].equals("B")) {
                            matrix[startRow][startCol] = ".";
                            if (startRow == borrow1Row && startCol == borrow1Col) {
                                startRow = borrow2Row;
                                startCol = borrow2Col;
                            } else {
                                startRow = borrow1Row;
                                startCol = borrow1Col;
                            }
                        }
                    } else {
                        gameOver = true;
                    }
                    break;
                case "left":
                    matrix[startRow][startCol] = ".";
                    startCol--;
                    if (isValidIndexes(size, size, startRow, startCol)) {
                        if (matrix[startRow][startCol].equals("*")) {
                            foodQuantity++;
                        } else if (matrix[startRow][startCol].equals("B")) {
                            matrix[startRow][startCol] = ".";
                            if (startRow == borrow1Row && startCol == borrow1Col) {
                                startRow = borrow2Row;
                                startCol = borrow2Col;
                            } else {
                                startRow = borrow1Row;
                                startCol = borrow1Col;
                            }
                        }
                    } else {
                        gameOver = true;
                    }
                    break;
                case "right":
                    matrix[startRow][startCol] = ".";
                    startCol++;
                    if (isValidIndexes(size, size, startRow, startCol)) {
                        if (matrix[startRow][startCol].equals("*")) {
                            foodQuantity++;
                        } else if (matrix[startRow][startCol].equals("B")) {
                            matrix[startRow][startCol] = ".";
                            if (startRow == borrow1Row && startCol == borrow1Col) {
                                startRow = borrow2Row;
                                startCol = borrow2Col;
                            } else {
                                startRow = borrow1Row;
                                startCol = borrow1Col;
                            }
                        }
                    } else {
                        gameOver = true;
                    }
                    break;
            }
            if (gameOver) {
                break;
            }


        }
        if (!gameOver) {
            matrix[startRow][startCol] = "S";
        }
        if (gameOver) {
            System.out.println("Game over!");
        }
        if (foodQuantity == 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + foodQuantity);
        printMatrix(matrix);
    }

    private static String[][] readMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] array = scanner.nextLine().split("");
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

    private static boolean isValidIndexes(int rows, int cols, int row, int col) {
        if (row >= 0 && row < rows) {
            if (col >= 0 && col < cols) {
                return true;
            }
        }
        return false;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String e : row) {
                System.out.print(e);
            }
            System.out.println();
        }
    }
}
