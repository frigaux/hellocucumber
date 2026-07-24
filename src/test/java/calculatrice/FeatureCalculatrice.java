package calculatrice;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FeatureCalculatrice {
    private String chaine;
    private Integer somme;
    private ChaineInvalideException exception;

    // une simple chaine de caractères contenant des nombres séparés par une virgule
    @Given("une chaine de caractères avec zéro ou plusieurs nombres {string} avec la virgule pour séparateur")
    public void une_chaine_de_caractères_avec_zéro_ou_plusieurs_nombres_avec_la_virgule_pour_séparateur(String chaine) {
        this.chaine = chaine;
    }

    // autoriser les retours à la ligne comme séparateur
    @Given("une chaine de caractères avec zéro ou plusieurs nombres {string} avec la virgule et le retour à la ligne comme séparateur")
    public void une_chaine_de_caractères_avec_zéro_ou_plusieurs_nombres_avec_la_virgule_et_le_retour_à_la_ligne_comme_séparateur(String chaine) {
        this.chaine = chaine;
    }

    // interdir deux séparateurs à la suite
    @Given("une chaine de caractères {string} avec deux séparateurs à la suite")
    public void une_chaine_de_caractères_avec_deux_séparateurs_à_la_suite(String chaine) {
        this.chaine = chaine;
    }

    // autoriser un séparateur spécifique
    @Given("une chaine de caractères {string} avec un séparateur spécifique défini en début de chaine")
    public void une_chaine_de_caractères_avec_un_séparateur_spécifique_défini_en_début_de_chaine(String chaine) {
        this.chaine = chaine;
    }

    // les nombres supérieurs à 1000 sont ignorés
    @Given("une chaine de caractères {string} avec un ou plusieurs nombres supérieurs à mille")
    public void une_chaine_de_caractères_avec_un_ou_plusieurs_nombres_supérieurs_à_mille(String chaine) {
        this.chaine = chaine;
    }

    // un nombre négatif lève une exception
    @Given("une chaine de caractères {string} avec un ou plusieurs nombres négatifs")
    public void une_chaine_de_caractères_avec_un_ou_plusieurs_nombres_négatifs(String chaine) {
        this.chaine = chaine;
    }

    // le séparateur spécifique peut avoir n'importe quelle longueur
    @Given("une chaine de caractères {string} avec un séparateur spécifique de n'importe quelle longueur")
    public void une_chaine_de_caractères_avec_un_séparateur_spécifique_de_n_importe_quelle_longueur(String chaine) {
        this.chaine = chaine;
    }


    @When("on fait la somme des nombres à l'intérieure")
    public void on_fait_la_somme_des_nombres_à_l_intérieure() {
        somme = null;
        exception = null;
        try {
            somme = new Calculatrice().ajouter(chaine);
        } catch (ChaineInvalideException e) {
            exception = e;
        }
    }


    @Then("le résultat est {int}")
    public void le_résultat_est(int resultat) {
        assertThat(somme).isEqualTo(resultat);
    }

    @Then("une exception {string} est levée")
    public void une_exception_est_levée(String exception) {
        assertThat(this.exception).hasToString("calculatrice." + exception);
    }

    @Then("une exception {string} est levée avec le message {string}")
    public void une_exception_est_levée_avec_le_message(String exception, String message) {
        assertThat(this.exception).hasToString("calculatrice." + exception + ": " + message);
    }
}
