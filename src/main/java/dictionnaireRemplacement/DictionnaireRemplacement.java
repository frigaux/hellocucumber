package dictionnaireRemplacement;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DictionnaireRemplacement {
    private Map<String, String> dictionnaire;
    private static final Pattern REGEXP_CLE = Pattern.compile("\\$(\\w+)\\$");

    public DictionnaireRemplacement(Map<String, String> dictionnaire) {
        this.dictionnaire = dictionnaire;
    }

    public String remplacerClesParValeur(String chaine) {
        final Matcher matcher = REGEXP_CLE.matcher(chaine);
        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                String cle = matcher.group(i);
                if (dictionnaire.containsKey(cle)) {
                    chaine = chaine.replace("$" + cle + "$", dictionnaire.get(cle));
                }
            }
        }
        return chaine;
    }
}
