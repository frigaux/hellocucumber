package nombresRomains;

import java.util.LinkedHashMap;

public class NombresRomains {
    private static LinkedHashMap<Integer, Character> tableConversion = new LinkedHashMap();
    private static LinkedHashMap<Integer, String> tableConversion2 = new LinkedHashMap();

    static {
        tableConversion.put(1000, 'M');
        tableConversion.put(500, 'D');
        tableConversion.put(100, 'C');
        tableConversion.put(50, 'L');
        tableConversion.put(10, 'X');
        tableConversion.put(5, 'V');
        tableConversion.put(1, 'I');

        tableConversion2.put(1000, "M");
        tableConversion2.put(900, "CM");
        tableConversion2.put(500, "D");
        tableConversion2.put(400, "CD");
        tableConversion2.put(100, "C");
        tableConversion2.put(90, "XC");
        tableConversion2.put(50, "L");
        tableConversion2.put(40, "XL");
        tableConversion2.put(10, "X");
        tableConversion2.put(9, "IX");
        tableConversion2.put(5, "V");
        tableConversion2.put(4, "IV");
        tableConversion2.put(1, "I");
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

    public static String convertirLatinVersRomain2(int nombreAConvertir) {
        StringBuilder sb = new StringBuilder();
        var nombres = tableConversion2.keySet();
        while (nombreAConvertir != 0) {
            for (int nombre : nombres) {
                if (nombreAConvertir >= nombre) {
                    nombreAConvertir -= nombre;
                    sb.append(tableConversion2.get(nombre));
                    break;
                }
            }
        }
        return sb.toString();
    }
}
