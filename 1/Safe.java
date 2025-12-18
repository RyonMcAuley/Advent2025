public class Safe {
    int arrow = 50;
    int count = 0;

    public void turn(String input) {
        char direction = input.charAt(0);
        int number = Integer.parseInt(input.substring(1));
        switch (direction) {
            case 'L':
                turnLeft(number);
                break;
            case 'R':
                turnRight(number);
                break;
            default:
                System.out.println("Not able to parse direction: " + direction);
        }
    }

    private void turnLeft(int number) {
        int pointsAtZero = 0;
        boolean fromZero = arrow == 0;

        // arrow = 0 - 5;
        arrow = arrow - number;
        // -5 > 0 ? no
        if (arrow > 0) {
            System.out.println("The dial is rotated L" + number + " to point at " + arrow);
            return;
        }
        while (arrow < 0) {
            arrow = arrow + 100;
            if (!fromZero) {
                count();
                pointsAtZero++;
            }
            fromZero = false;
        }
        if (arrow == 0) {
            count();
        }

        System.out.print("The dial is rotated L" + number + " to point at " + arrow);
        if (pointsAtZero > 0) {
            System.out.println("; during this rotation, it points at 0 " + pointsAtZero + " times.");
        } else {
            System.out.println();
        }
    }

    private void turnRight(int number) {
        int pointsAtZero = 0;

        arrow = arrow + number;
        if (arrow < 100) {
            System.out.println("The dial is rotated R" + number + " to point at " + arrow);
            return;
        }
        while (arrow >= 100) {
            arrow = arrow - 100;
            count();
            pointsAtZero++;
        }

        System.out.print("The dial is rotated R" + number + " to point at " + arrow);
        if (pointsAtZero > 0) {
            System.out.println("; during this rotation, it points at 0 " + pointsAtZero + " times.");
        } else {
            System.out.println();
        }
    }

    public int getAnswer() {
        return count;
    }

    private void count() {
        System.out.println("Increment count: " + ++count);
    }
}
