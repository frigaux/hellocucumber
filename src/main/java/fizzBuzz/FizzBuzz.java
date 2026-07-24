package fizzBuzz;

public class FizzBuzz {
    private static final int BUZZ_VALUE = 5;
    private static final int FIZZ_VALUE = 3;

    private static final String BUZZ = "Buzz";
    private static final String FIZZ = "Fizz";
    private static final String FIZZ_BUZZ = FIZZ + BUZZ;

    public static String of(int value) {
        if (isFizzBuzz(value)) {
            return FIZZ_BUZZ;
        }

        if (isBuzz(value)) {
            return BUZZ;
        }

        if (isFizz(value)) {
            return FIZZ;
        }

        return String.valueOf(value);
    }

    private static boolean isFizzBuzz(int value) {
        return isFizz(value) && isBuzz(value);
    }

    private static boolean isBuzz(int value) {
        return value % BUZZ_VALUE == 0;
    }

    private static boolean isFizz(int value) {
        return value % FIZZ_VALUE == 0;
    }
}
