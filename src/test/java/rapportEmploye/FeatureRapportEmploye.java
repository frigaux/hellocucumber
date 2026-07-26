package rapportEmploye;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FeatureRapportEmploye {
    private List<Employe> employes;
    private List<Employe> liste;

    private List<Employe> parseListe(String liste) {
        String[] clesValeurs = liste.split(",");
        this.employes = new ArrayList<Employe>();
        for (String cleValeur : clesValeurs) {
            String[] cleEtValeur = cleValeur.split(":");
            if (cleEtValeur.length == 2) {
                employes.add(new Employe(cleEtValeur[0], Integer.parseInt(cleEtValeur[1])));
            }
        }
        return employes;
    }

    @Given("une liste d'employés {string}")
    public void une_liste_d_employés(String liste) {
        this.employes = parseListe(liste);
    }


    @When("on demande la liste des employés qui ont au moins 18 ans")
    public void on_demande_la_liste_des_employés_qui_ont_au_moins_18_ans() {
        this.liste = RapportEmploye.auMoins18(this.employes);
    }

    @When("on demande le tri alphabétique de la liste")
    public void on_demande_le_tri_alphabétique_de_la_liste() {
        this.liste = RapportEmploye.trieeAlphabetiquement(this.employes);
    }

    @When("on demande la mise en majuscule de la liste")
    public void on_demande_la_mise_en_majuscule_de_la_liste() {
        this.liste = RapportEmploye.enMajuscule(this.employes);
    }

    @When("on demande le tri anti-alphabétique de la liste")
    public void on_demande_le_tri_anti_alphabétique_de_la_liste() {
        this.liste = RapportEmploye.trieeAntiAlphabetiquement(this.employes);
    }


    @Then("on récupère la liste {string}")
    public void on_récupère_la_liste(String listeAttendue) {
        assertThat(this.liste).isEqualTo(parseListe(listeAttendue));
    }
}
