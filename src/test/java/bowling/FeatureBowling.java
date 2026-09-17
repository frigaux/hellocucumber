package bowling;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FeatureBowling {
    private String resultats;
    private int score;

    @Given("les {string} d'une partie de bowling")
    public void les_d_une_partie_de_bowling(String resultats) {
        this.resultats = resultats;
    }

    @When("on calcule le score")
    public void on_calcule_le_score() {
        this.score = Bowling.calculerScore(this.resultats);
    }

    @Then("on obtient le {int}")
    public void on_obtient_le(Integer scoreAttendu) {
        assertThat(this.score).isEqualTo(scoreAttendu);
    }
}
