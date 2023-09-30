package bg.codexio.riddles.colorfulballs;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class BallsBox {

    public static void main(String[] args) {

        Map<String, Integer> ballsColorCount = new HashMap<>();

        try {
            fillBoxWithBalls(ballsColorCount);

            int ballsToRemove = minBallsToRemove(ballsColorCount);

            printResult(ballsToRemove);

        } catch (BallsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fillBoxWithBalls(Map<String, Integer> ballsColorCount) throws BallsException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if ("End".equalsIgnoreCase(input)) {
                break;
            }
            String[] ballData = input.split(":\\s+");
            String color = ballData[0].toLowerCase(Locale.ROOT);
            int count = Integer.parseInt(ballData[1]);

            if (count < 1) {
                throw new BallsException("Number of balls added to box should be more than 0.");
            }

            if (ballsColorCount.containsKey(color)) {
                ballsColorCount.put(color, ballsColorCount.get(color) + count);
            } else {
                ballsColorCount.put(color, count);
            }
        }
        if (ballsColorCount.isEmpty()) {
            throw new BallsException("The ball box is empty.");
        }
    }

    public static int minBallsToRemove(Map<String, Integer> ballCounts) throws BallsException {
        if (ballCounts.size() == 1) {
            throw new BallsException("There is only one color of balls in the box.");
        }
        int totalBalls = ballCounts.values().stream().mapToInt(Integer::intValue).sum();

        return totalBalls - 1;
    }

    private static void printResult(int ballsToRemove) {
        System.out.printf("We have to remove at least %d balls" +
                " to make sure that only one color of balls remains.\n", ballsToRemove);
    }
}
