import java.nio.file.Path;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        int arrow = 50;
        int count = 0;
        try (var scanner = new Scanner(Path.of("code.txt"))) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
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
            System.out.println("Quick answer: " + count);
        } catch (IOException ex) {
            throw new RuntimeException("Error reading file");
        }

        // alt approach
        Safe safe = new Safe();
        try (var scanner = new Scanner(Path.of("code.txt"))) {
            while (scanner.hasNextLine()) {
                safe.turn(scanner.nextLine());
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error reading file");
        }

        System.out.println("Object answer: " + safe.getAnswer());
    }
}
