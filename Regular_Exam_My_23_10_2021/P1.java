package Regular_Exam_My_23_10_2021;

import java.util.*;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> queueIngredients = new ArrayDeque<>();
        Deque<Integer> stackFreshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(e -> queueIngredients.offer(e));
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(e -> stackFreshness.push(e));
        Map<String, Integer> map = new TreeMap<>();
//Pear Sour
//150
//The Harvest
//250
//Apple Hinny
//300
//High Fashion
//400
        map.put("Pear Sour", 0);
        map.put("The Harvest", 0);
        map.put("Apple Hinny", 0);
        map.put("High Fashion", 0);
        boolean isWin = true;
        while (!queueIngredients.isEmpty() && !stackFreshness.isEmpty()) {
            int temp = queueIngredients.peek();
            while (temp == 0) {
                queueIngredients.poll();
                if (!queueIngredients.isEmpty()) {
                    temp = queueIngredients.peek();
                } else {
                    break;
                }

            }
//            if (queueIngredients.peek() == 0) {
//                queueIngredients.poll();
//            }
            if (!queueIngredients.isEmpty()) {
                int queueValue = queueIngredients.poll();
                int stackValue = stackFreshness.pop();
                int multiplication = queueValue * stackValue;
                if (multiplication == 150) {
                    map.put("Pear Sour", map.get("Pear Sour") + 1);
                } else if (multiplication == 250) {
                    map.put("The Harvest", map.get("The Harvest") + 1);
                } else if (multiplication == 300) {
                    map.put("Apple Hinny", map.get("Apple Hinny") + 1);
                } else if (multiplication == 400) {
                    map.put("High Fashion", map.get("High Fashion") + 1);
                } else {
                    queueIngredients.offer(queueValue + 5);
                }
            } else {
                isWin = false;
            }

        }

        for (int value : map.values()) {
            if (value == 0) {
                isWin = false;
                break;
            }
        }
        if (isWin) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        int sum = 0;
        if (!queueIngredients.isEmpty()) {
            for (Integer value : queueIngredients) {
                sum += value;
            }
            System.out.println("Ingredients left: " + sum);
        }
//        # {cocktail name} --> {amount}
        for (var entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println("# " + entry.getKey() + " --> " + entry.getValue());
            }
        }
    }
}
