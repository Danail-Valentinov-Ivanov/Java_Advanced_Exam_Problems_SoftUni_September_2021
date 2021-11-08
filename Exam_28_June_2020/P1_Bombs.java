package Exam_28_June_2020;

import java.util.*;
import java.util.stream.Collectors;

public class P1_Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> queueEffect = new ArrayDeque<>();
        Deque<Integer> stackCasing = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).forEach(e -> queueEffect.offer(e));
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).forEach(e -> stackCasing.push(e));
        Map<String, Integer> mapBombs = new TreeMap<>();
        mapBombs.put("Datura Bombs", 0);
        mapBombs.put("Cherry Bombs", 0);
        mapBombs.put("Smoke Decoy Bombs", 0);
        boolean isWin = false;
        while (!queueEffect.isEmpty() && !stackCasing.isEmpty()) {
            int queueDigit = queueEffect.peek();
            int stackDigit = stackCasing.pop();
            int sum = queueDigit + stackDigit;
            if (sum == 40) {
                mapBombs.put("Datura Bombs", mapBombs.get("Datura Bombs") + 1);
                queueEffect.poll();
            } else if (sum == 60) {
                mapBombs.put("Cherry Bombs", mapBombs.get("Cherry Bombs") + 1);
                queueEffect.poll();
            } else if (sum == 120) {
                mapBombs.put("Smoke Decoy Bombs", mapBombs.get("Smoke Decoy Bombs") + 1);
                queueEffect.poll();
            } else {
                stackCasing.push(stackDigit - 5);
            }
            if (mapBombs.get("Datura Bombs") >= 3 && mapBombs.get("Cherry Bombs") >= 3
                    && mapBombs.get("Smoke Decoy Bombs") >= 3) {
                isWin = true;
                break;
            }
        }
        if (isWin) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (queueEffect.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " + queueEffect.stream().map(e -> e.toString())
                    .collect(Collectors.joining(", ")));
        }
        if (stackCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: " + stackCasing.stream().map(e -> e.toString())
                    .collect(Collectors.joining(", ")));
        }
        for (var entry : mapBombs.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
