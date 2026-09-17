package bowling;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bowling {
    private static final Pattern SPARE = Pattern.compile("^(\\d)\\/(\\d)?$");
    private static final Pattern MISS = Pattern.compile("^(\\d)-$");

    public static int calculerScore(String resultats) {
        String[] parties = resultats.split(" ");
        int score = 0;
        for (int i = 0; i < 10; i++) {
            String partie = parties[i];
            if (partie.equals("X")) {
                score += 10 + quilles(parties[i + 1]) + quilles(parties[i + 2]);
            }
            Matcher spare = SPARE.matcher(partie);
            if (spare.find()) {
                if (spare.group(2) == null) {
                    score += 10 + quilles(parties[i + 1]);
                } else {
                    score += 10 + Integer.parseInt(spare.group(2));
                }
            }
            Matcher miss = MISS.matcher(partie);
            if (miss.find()) {
                score += Integer.parseInt(miss.group(1));
            }
        }
        return score;
    }

    private static int quilles(String partie) {
        if (partie.equals("X")) {
            return 10;
        }
        Matcher spare = SPARE.matcher(partie);
        if (spare.find()) {
            return Integer.parseInt(spare.group(1));
        }
        Matcher miss = MISS.matcher(partie);
        if (miss.find()) {
            return Integer.parseInt(miss.group(1));
        }
        return 0;
    }
}
