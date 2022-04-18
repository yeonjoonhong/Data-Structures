package src.week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu1 {
    public static void main(String[] args) {
        Driver.main(args);
    }
}


class Driver {
    public static void main(String[] args) {
        System.out.println("\nWeek 1 Menu:");

        String selection;
        Scanner sc = new Scanner(System.in);
        Map<String, MenuRow> menu = new HashMap<>();
        menu.put("e", new MenuRow("Exit Application", null));
        menu.put("1", new MenuRow("Queue Test", () -> QueueTester.main(null)));
        menu.put("2", new MenuRow("Merge Queues", () -> QueueOrder.main(null)));
        menu.put("3", new MenuRow("Stack", () -> stack.main(null)));

        for (Map.Entry<String, MenuRow> pair : menu.entrySet()) {
            System.out.println(pair.getKey() + " ==> " + pair.getValue().getName());
        }

        try {
            selection = sc.nextLine();

            try {
                MenuRow row = menu.get(selection);
                if (row.getName().equals("Exit Application")) return;
                row.run();

            } catch (Exception e) {
                System.out.printf("\nInvalid selection: %d \n\n", selection);
            }
        } catch (Exception e) {
            System.out.println("\nInput is not a number\n");
        }
        Driver.main(null);

    }
}


class MenuRow {
    String title;
    Runnable action;

    public MenuRow(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return this.title;
    }
    public Runnable getAction() {
        return this.action;
    }

    public void run() {
        action.run();
    }

    public String getName() { return this.title; }
}