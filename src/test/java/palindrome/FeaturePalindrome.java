package palindrome;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FeaturePalindrome {
    private String mot;
    private String resultat;

    @Given("un mot {string}")
    public void un_mot(String mot) {
        this.mot = mot;
    }

    @When("on génère un palindrome")
    public void on_génère_un_palindrome() {
        resultat = Palindrome.generer(this.mot);
    }

    @Then("on récupère le palindrome {string}")
    public void on_récupère_le_palindrome(String palindrome) {
        assertThat(this.resultat).isEqualTo(palindrome);
    }
}
