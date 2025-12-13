public class Safe {
    int arrow = 50;
    int count = 0;

    public void turn(String input)
    {
        System.out.println(input);
        char direction = input.charAt(0);
        int number = Integer.parseInt(input.substring(1));
        // System.out.println(direction);
        // System.out.println(number);
        switch(direction) {
            case 'L':
                turnLeft(number);
                break;
            case 'R':
                turnRight(number);
                break;
            default:
                System.out.println("wat da hail : " + direction);
        }
    }

    private void turnLeft(int number)
    {
        System.out.println("Turning left from " + arrow + " by " + number);
        arrow = arrow - number;
        if (arrow > 0)
            return;
        while (arrow < 0)
        {
            arrow = arrow + 100;
        }
        if (arrow == 0)
            count ++;
    }

    private void turnRight(int number)
    {
        System.out.println("Turning right from " + arrow + " by " + number);
        arrow = arrow + number;
        if (arrow < 100)
            return;
        while (arrow >= 100)
        {
            arrow = arrow - 100;
        }
        if (arrow == 0)
            count++;
    }

    public int getAnswer()
    {
        return count;
    }
}
