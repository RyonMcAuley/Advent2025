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
        boolean fromZero = arrow == 0;

        arrow = arrow - number;
        if (arrow > 0) {
            return;
        }
        while (arrow < 0) {
            arrow = arrow + 100;
            if (!fromZero) {
                count++;
            }
            fromZero = false;
        }
        if (arrow == 0) {
            count++;
        }
    }

    private void turnRight(int number) {
        arrow = arrow + number;
        if (arrow < 100) {
            return;
        }
        while (arrow >= 100) {
            arrow = arrow - 100;
            count++;
        }
    }

    public int getAnswer() {
        return count;
    }
}
