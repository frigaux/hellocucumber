package nombresRomains;

import java.util.LinkedHashMap;

public class NombresRomains {
    private static LinkedHashMap<Integer, Character> tableConversion = new LinkedHashMap();

    static {
        tableConversion.put(1000, 'M');
        tableConversion.put(500, 'D');
        tableConversion.put(100, 'C');
        tableConversion.put(50, 'L');
        tableConversion.put(10, 'X');
        tableConversion.put(5, 'V');
        tableConversion.put(1, 'I');
    }

    public static String convertirLatinVersRomain(int nombreAConvertir) {
        StringBuffer resultat = new StringBuffer();
        Integer[] cles = tableConversion.keySet().toArray(new Integer[0]);
        for (int i1 = 0; i1 < cles.length; i1++) {
            int nombreLatin = cles[i1];
            int quotient = nombreAConvertir / nombreLatin;
            if (quotient == 0) { // on essaie de faire une soustraction
                // un symbole qui précède un symbole de valeur supérieure se soustrait à ce dernier
                for (int i2 = i1 + 1; i2 < cles.length; i2++) {
                    int nombreLatinSoustraction = cles[i2];
                    if (2 * nombreLatinSoustraction != nombreLatin) {
                        quotient = nombreAConvertir / (nombreLatin - nombreLatinSoustraction);
                        if (quotient == 1) {
                            resultat.append(tableConversion.get(nombreLatinSoustraction));
                            resultat.append(tableConversion.get(nombreLatin));
                            nombreAConvertir -= nombreLatin - nombreLatinSoustraction;
                        }
                    }
                }
            } else { // cas normal : les symboles se suivent et s'additionnent
                for (int i = 0; i < quotient; i++) {
                    resultat.append(tableConversion.get(nombreLatin));
                }
                nombreAConvertir -= quotient * nombreLatin;
            }
        }
        return resultat.toString();
    }
}
