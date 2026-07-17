package attrapeMoiSiTuPeux;

import java.util.List;

public class Joueur {
    public Integer x;
    public Integer y;
    public Orientation orientation;
    private List<Orientation> orientationTriees = List.of(Orientation.NORD, Orientation.EST, Orientation.SUD, Orientation.OUEST);

    public Joueur(Integer x, Integer y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void tourner(Direction direction) {
        int idx = orientationTriees.indexOf(orientation);
        switch (direction) {
            case DROITE -> {
                idx = (idx + 1) % 4;
            }
            case GAUCHE -> {
                idx--;
                if (idx < 0) {
                    idx = 3;
                }
            }
        }
        this.orientation = orientationTriees.get(idx);
    }

    public void avancer(int nombreCases) {
        if (nombreCases == 1 || nombreCases == 2) {
            switch (orientation) {
                case NORD -> {
                    y = Math.max(0, y - nombreCases);
                }
                case EST -> {
                    x = Math.min(9, x + nombreCases);
                }
                case SUD -> {
                    y = Math.min(9, y + nombreCases);
                }
                case OUEST -> {
                    x = Math.max(0, x - nombreCases);
                }
            }
        }
    }
}
