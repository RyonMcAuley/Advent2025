import java.nio.file.Path;
import java.util.Scanner;
import java.io.IOException;

public class Day1 {
    public static int arrow = 50;
    public static int count = 0;

    public static void main(String[] args) {

        // long start = System.currentTimeMillis();
        try (var scanner = new Scanner(Path.of("code.txt"))) {
            while (scanner.hasNextLine()) {
                handleTurn(scanner.nextLine());
            }
            // long end = System.currentTimeMillis();
            System.out.println("Quick answer: " + count);
            // System.out.println("Time elapsed: " + (end - start));
        } catch (IOException ex) {
            throw new RuntimeException("Error reading file");
        }

        // alt approach
        // long start2 = System.currentTimeMillis();
        Safe safe = new Safe();
        try (var scanner = new Scanner(Path.of("code.txt"))) {
            while (scanner.hasNextLine()) {
                safe.turn(scanner.nextLine());
            }
            // long end2 = System.currentTimeMillis();
            System.out.println("Object answer: " + safe.getAnswer());
            // System.out.println("Time elapsed: " + (end2 - start2));
        } catch (IOException ex) {
            throw new RuntimeException("Error reading file");
        }
    }

    private static void handleTurn(String input) {
        char direction = input.charAt(0);
        int number = Integer.parseInt(input.substring(1));
        switch (direction) {
            case 'L':
                arrow = arrow - number;
                while (arrow < 0) {
                    arrow = arrow + 100;
                }
                if (arrow == 0)
                    count++;
                break;
            case 'R':
                arrow = arrow + number;
                while (arrow >= 100) {
                    arrow = arrow - 100;
                }
                if (arrow == 0)
                    count++;
                break;
            default:
                System.out.println("Something went wrong...");
        }
    }
}
