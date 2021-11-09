package Regular_Exam_My_23_10_2021;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = readMatrix(scanner, size, size);
        int currentRow = findStartRow(matrix, size, size);
        int currentCol = findStartCol(matrix, size, size);
        matrix[currentRow][currentCol] = "-";
        String command = scanner.nextLine();
        int cheese = 0;
//        right
//down
//down
//left
        boolean isEnd = false;
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    currentRow--;
                    if (isValidIndexes(size, size, currentRow, currentCol)) {
                        if (matrix[currentRow][currentCol].equals("c")) {
                            matrix[currentRow][currentCol] = "-";
                            cheese++;
                        } else if (matrix[currentRow][currentCol].equals("B")) {
                            matrix[currentRow][currentCol] = "-";
                            currentRow--;
                            if (matrix[currentRow][currentCol].equals("c")){
                                cheese++;
                                matrix[currentRow][currentCol] = "-";
                            }
                        }
                    } else {
                        isEnd = true;
                    }
                    break;
                case "down":
                    currentRow++;
                    if (isValidIndexes(size, size, currentRow, currentCol)) {
                        if (matrix[currentRow][currentCol].equals("c")) {
                            matrix[currentRow][currentCol] = "-";
                            cheese++;
                        } else if (matrix[currentRow][currentCol].equals("B")) {
                            matrix[currentRow][currentCol] = "-";
                            currentRow++;
                            if (matrix[currentRow][currentCol].equals("c")){
                                cheese++;
                                matrix[currentRow][currentCol] = "-";
                            }
                        }
                    } else {
                        isEnd = true;
                    }
                    break;
                case "left":
                    currentCol--;
                    if (isValidIndexes(size, size, currentRow, currentCol)) {
                        if (matrix[currentRow][currentCol].equals("c")) {
                            matrix[currentRow][currentCol] = "-";
                            cheese++;
                        } else if (matrix[currentRow][currentCol].equals("B")) {
                            matrix[currentRow][currentCol] = "-";
                            currentCol--;
                            if (matrix[currentRow][currentCol].equals("c")){
                                cheese++;
                                matrix[currentRow][currentCol] = "-";
                            }
                        }
                    } else {
                        isEnd = true;
                    }
                    break;
                case "right":
                    currentCol++;
                    if (isValidIndexes(size, size, currentRow, currentCol)) {
                        if (matrix[currentRow][currentCol].equals("c")) {
                            matrix[currentRow][currentCol] = "-";
                            cheese++;
                        } else if (matrix[currentRow][currentCol].equals("B")) {
                            matrix[currentRow][currentCol] = "-";
                            currentCol++;
                            if (matrix[currentRow][currentCol].equals("c")){
                                cheese++;
                                matrix[currentRow][currentCol] = "-";
                            }
                        }
                    } else {
                        isEnd = true;
                    }
                    break;
            }
            if (isEnd) {
                break;
            }
            command = scanner.nextLine();
        }
        if (isEnd) {
            System.out.println("Where is the mouse?");
        } else {
            matrix[currentRow][currentCol] = "M";
        }
        if (cheese < 5) {
            int needed = 5 - cheese;
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", needed);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", cheese);
        }
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

    private static int findStartRow(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals("M")) {
                    return row;
                }
            }
        }
        return 0;
    }

    private static int findStartCol(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals("M")) {
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
