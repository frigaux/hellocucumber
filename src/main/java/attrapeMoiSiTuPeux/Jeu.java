package attrapeMoiSiTuPeux;

public class Jeu {
    public Vision unJoueurVoitIlUnSecond(Joueur joueur1, Joueur joueur2) {
        return switch (joueur1.orientation) {
            case SUD -> {
                if (joueur1.x.equals(joueur2.x) && joueur1.y < joueur2.y) {
                    yield new Vision(true, joueur2.y - joueur1.y);
                } else {
                    yield new Vision(false, 0);
                }
            }
            case OUEST -> {
                if (joueur1.y.equals(joueur2.y) && joueur1.x > joueur2.x) {
                    yield new Vision(true, joueur1.x - joueur2.x);
                } else {
                    yield new Vision(false, 0);
                }
            }
            case NORD -> {
                if (joueur1.x.equals(joueur2.x) && joueur1.y > joueur2.y) {
                    yield new Vision(true, joueur1.y - joueur2.y);
                } else {
                    yield new Vision(false, 0);
                }
            }
            case EST -> {
                if (joueur1.y.equals(joueur2.y) && joueur1.x < joueur2.x) {
                    yield new Vision(true, joueur2.x - joueur1.x);
                } else {
                    yield new Vision(false, 0);
                }
            }
        };
    }

    public Boolean unJoueurAGagne(Joueur joueur1, Joueur joueur2) {
        return joueur1.x.equals(joueur2.x) && joueur1.y.equals(joueur2.y);
    }
}
