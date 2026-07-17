package calculatrice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculatrice {
    private static Pattern regexpSeparateurPersonnalise = Pattern.compile("//([^\n]+)\n");
    private static Pattern regexpNombresValides = Pattern.compile("^(\\d+)([\\n,]{1}(\\d+))*$", Pattern.MULTILINE);
    private static Pattern regexpNombreNegatif = Pattern.compile("-\\d+", Pattern.MULTILINE);

    public int ajouter(String chainesCaracteres) throws ChaineInvalideException {
        if (chainesCaracteres == null || chainesCaracteres.isEmpty()) {
            return 0;
        }
        Matcher matcher = regexpSeparateurPersonnalise.matcher(chainesCaracteres);
        if (matcher.find()) {
            String separateur = matcher.group(1);
            return ajouterAvecSeparateurPersonnalise(chainesCaracteres.substring(separateur.length() + 3), separateur);
        } else {
            return ajouterAvecSeparateursCommuns(chainesCaracteres);
        }
    }

    private int ajouterAvecSeparateursCommuns(String nombres) {
        detecterNombreNegatif(nombres);
        if (regexpNombresValides.matcher(nombres).matches()) {
            String[] nn = nombres.split("\n|,");
            return sommeString(nn);
        } else {
            throw new ChaineInvalideException();
        }
    }

    private int ajouterAvecSeparateurPersonnalise(String nombres, String separateur) {
        detecterNombreNegatif(nombres);
        Pattern nombresValides = Pattern.compile("^(\\d+)(" + separateur + "(\\d+))*$", Pattern.MULTILINE);
        if (nombresValides.matcher(nombres).matches()) {
            String[] ss = nombres.split(separateur);
            return sommeString(ss);
        } else {
            throw new ChaineInvalideException();
        }
    }

    private void detecterNombreNegatif(String nombres) {
        if (regexpNombreNegatif.matcher(nombres).find()) {
            throw new ChaineInvalideException("les nombres négatifs ne sont pas autorisés");
        }
    }

    private Integer sommeString(String[] ss) {
        Integer somme = 0;
        for (String s : ss) {
            int n = Integer.parseInt(s);
            somme += n > 1000 ? 0 : n;
        }
        return somme;
    }
}