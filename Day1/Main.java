import java.nio.file.Path;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Safe safe = new Safe();
        try (var scanner = new Scanner(Path.of("code.txt"))) {
            while (scanner.hasNextLine()) {
                safe.turn(scanner.nextLine());
            }
        } catch (IOException ex) {
            throw new RuntimeException("bleehhh");
        }

        // print the number of times landed on 0
        System.out.println(safe.getAnswer());
    }
}
