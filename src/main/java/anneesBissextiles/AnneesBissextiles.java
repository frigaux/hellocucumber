package anneesBissextiles;

public class AnneesBissextiles {

    public static boolean estBissextile(int annee) {
        return new Annee(annee).estBissextile();
    }

    private static class Annee {

        private final int year;

        public Annee(int year) {
            this.year = year;
        }

        private boolean estBissextile() {
            if (year % 400 == 0) {
                return true;
            }

            if (year % 100 == 0) {
                return false;
            }

            if (year % 4 == 0) {
                return true;
            }

            return false;
        }
    }
}
