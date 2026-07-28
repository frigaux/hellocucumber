package fizzBuzz;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FeatureFizzBuzz {
    private int nombre;
    private String resultat;

    @Given("un nombre {int}")
    public void un_nombre(int nombre) {
        this.nombre = nombre;
    }

    @When("on applique les règles du jeu FizzBuzz")
    public void on_applique_les_règles_du_jeu_fizz_buzz() {
        resultat = FizzBuzz.appliquer(nombre);
    }

    @Then("l'élève doit dire {string}")
    public void l_élève_doit_dire(String resultatAttendu) {
        assertThat(this.resultat).isEqualTo(resultatAttendu);
    }
}
