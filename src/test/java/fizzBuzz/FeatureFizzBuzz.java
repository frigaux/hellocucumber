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

    @When("on applique l'algorithme FizzBuzz")
    public void on_applique_l_algorithme_fizz_buzz() {
        resultat = FizzBuzz.of(nombre);
    }

    @Then("le résultat doit être {string}")
    public void le_résultat_doit_être(String resultat) {
        assertThat(this.resultat).isEqualTo(resultat);
    }
}
