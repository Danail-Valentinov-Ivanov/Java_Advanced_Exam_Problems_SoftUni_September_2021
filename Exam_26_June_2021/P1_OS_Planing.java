package Exam_26_June_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P1_OS_Planing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> stackTask = new ArrayDeque<>();
        Deque<Integer> queueThread = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).forEach(e -> stackTask.push(e));
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(e -> queueThread.offer(e));
        int taskToBeKilled = Integer.parseInt(scanner.nextLine());
        boolean isKilledTask = false;
        while (!isKilledTask) {
            int stackValue = stackTask.peek();
            int queueValue = queueThread.peek();
            if (stackValue == taskToBeKilled) {
                System.out.printf("Thread with value %d killed task %d\n", queueValue, stackValue);
                isKilledTask = true;
            } else if (queueValue >= stackValue) {
                stackTask.pop();
                queueThread.poll();
            } else if (queueValue < stackValue) {
                queueThread.poll();
            }
        }
        for (int thread : queueThread) {
            System.out.print(thread + " ");
        }
    }
}
