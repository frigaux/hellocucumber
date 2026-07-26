package rapportEmploye;

import java.util.List;

public class RapportEmploye {
    public static List<Employe> auMoins18(List<Employe> employes) {
        return employes.stream().filter(employe -> employe.age() >= 18).toList();
    }

    public static List<Employe> trieeAlphabetiquement(List<Employe> employes) {
        return employes.stream()
                .sorted((e1, e2) -> e1.nom().compareTo(e2.nom()))
                .toList();
    }

    public static List<Employe> enMajuscule(List<Employe> employes) {
        return employes.stream()
                .map(employe -> new Employe(employe.nom().toUpperCase(), employe.age()))
                .toList();
    }

    public static List<Employe> trieeAntiAlphabetiquement(List<Employe> employes) {
        return employes.stream()
                .sorted((e1, e2) -> e2.nom().compareTo(e1.nom()))
                .toList();
    }
}
