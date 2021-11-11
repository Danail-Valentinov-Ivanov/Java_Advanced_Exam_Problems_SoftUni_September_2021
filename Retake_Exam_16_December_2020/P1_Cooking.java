package Retake_Exam_16_December_2020;

import java.util.*;
import java.util.stream.Collectors;

public class P1_Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> queueLiquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(() -> new ArrayDeque<>()));
        Deque<Integer> stackIngredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(e -> stackIngredients.push(e));
        int[] array = new int[4];
        while (!queueLiquids.isEmpty() && !stackIngredients.isEmpty()) {
            int currentLiquid = queueLiquids.poll();
            int currentIngredient = stackIngredients.pop();
            int sum = currentLiquid + currentIngredient;
            if (sum == 25 || sum == 50 || sum == 75 || sum == 100) {
                if (sum == 25) {
                    array[0] += 1;
                } else if (sum == 50) {
                    array[1] += 1;
                } else if (sum == 75) {
                    array[3] += 1;
                } else if (sum == 100) {
                    array[2] += 1;
                }
            } else {
                stackIngredients.push(currentIngredient + 3);
            }
        }
        boolean isReady = true;
        for (int e : array) {
            if (e == 0) {
                isReady = false;
            }
        }
        if (isReady) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (queueLiquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + queueLiquids.stream().map(obj -> String.valueOf(obj))
                    .collect(Collectors.joining(", ")));
        }
        if (stackIngredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + stackIngredients.stream().map(obj -> String.valueOf(obj))
                    .collect(Collectors.joining(", ")));
        }
        System.out.println("Bread: " + array[0]);
        System.out.println("Cake: " + array[1]);
        System.out.println("Fruit Pie: " + array[2]);
        System.out.println("Pastry: " + array[3]);
    }
}
