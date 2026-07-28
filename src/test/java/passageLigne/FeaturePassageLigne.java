package passageLigne;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FeaturePassageLigne {
    private String chaine;
    private int nbCaracteresMax;
    private String resultat;

    @Given("une chaine de caractère {string} ainsi qu'un nombre maximum de caractères par ligne {int}")
    public void une_chaine_de_caractère_ainsi_qu_un_nombre_maximum_de_caractères_par_ligne(String chaine, int nbCaracteresMax) {
        this.chaine = chaine;
        this.nbCaracteresMax = nbCaracteresMax;
    }

    @When("on applique le retour à la ligne automatique")
    public void on_applique_le_retour_à_la_ligne_automatique() {
        this.resultat = PassageLigne.insererRetourLigne(chaine, nbCaracteresMax);
    }

    @Then("on obtient la chaine {string}")
    public void on_obtient_la_chaine(String resultatAttendu) {
        assertThat(resultat).isEqualTo(resultatAttendu);
    }
}
