package Exam_20_February_2021;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P1_Magic_Box {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        String[] sequenceQueue = scanner.nextLine().split("\\s+");
        String[] sequenceStack = scanner.nextLine().split("\\s+");
        for (String e : sequenceQueue) {
            queue.offer(Integer.parseInt(e));
        }
        for (String e : sequenceStack) {
            stack.push(Integer.parseInt(e));
        }
        int sumClaimedItems = 0;
        while (queue.size() != 0 && stack.size() != 0) {
            int digitQueue = queue.peek();
            int digitStack = stack.peek();
            int sum = digitQueue + digitStack;
            if (sum % 2 == 0) {
                sumClaimedItems += sum;
                queue.poll();
                stack.pop();
            } else {
                queue.add(stack.poll());
            }
        }
        if (queue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else if (stack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (sumClaimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + sumClaimedItems);
        } else {
            System.out.println("Poor prey... Value: " + sumClaimedItems);
        }
    }
}
