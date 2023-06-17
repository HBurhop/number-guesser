import java.util.Random;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i <= 10000000; i++) {
            Random r = new Random();
            short randomNumber = (short) (r.nextInt(Short.MAX_VALUE * 2 + 1) - Short.MAX_VALUE);
            Solution solution = new Solution();
            boolean result = solution.guessNumber(randomNumber);
            if (!result) {
                System.out.println("Ergebnis nicht erreicht: " + randomNumber);
            }
        }
    }
}