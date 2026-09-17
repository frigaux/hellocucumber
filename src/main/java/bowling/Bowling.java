package bowling;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bowling {
    private static final Pattern SPARE = Pattern.compile("^(\\d)\\/(\\d)?$");
    private static final Pattern MISS = Pattern.compile("^(\\d)-$");

    public static int calculerScore(String resultats) {
        String[] tours = resultats.split(" ");
        int score = 0;
        for (int i = 0; i < 10; i++) {
            String tour = tours[i];
            if (estStrike(tour)) {
                score += 10 + quillesTombees(tours[i + 1]) + quillesTombees(tours[i + 2]);
            }
            Matcher spare = SPARE.matcher(tour);
            if (spare.find()) {
                if (spare.group(2) == null) {
                    score += 10 + quillesTombees(tours[i + 1]);
                } else {
                    score += 10 + Integer.parseInt(spare.group(2));
                }
            }
            Matcher miss = MISS.matcher(tour);
            if (miss.find()) {
                score += Integer.parseInt(miss.group(1));
            }
        }
        return score;
    }

    private static boolean estStrike(String tour) {
        return tour.equals("X");
    }

    private static int quillesTombees(String tour) {
        if (tour.equals("X")) {
            return 10;
        }
        Matcher spare = SPARE.matcher(tour);
        if (spare.find()) {
            return Integer.parseInt(spare.group(1));
        }
        Matcher miss = MISS.matcher(tour);
        if (miss.find()) {
            return Integer.parseInt(miss.group(1));
        }
        throw new IllegalArgumentException(tour);
    }
}
