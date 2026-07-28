package nombresRomains;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FeatureNombresRomains {
    private int nombre;
    private String resultat;

    @Given("un nombre latin {int}")
    public void un_nombre_latin(int nombre) {
        this.nombre = nombre;
    }

    @When("on applique la numérotation Romaine")
    public void on_applique_la_numérotation_romaine() {
        this.resultat = NombresRomains.convertirLatinVersRomain(nombre);
    }

    @Then("on obtient le nombre Romain {string}")
    public void on_obtient_le_nombre_romain(String resultat) {
        assertThat(this.resultat).isEqualTo(resultat);
    }
}
