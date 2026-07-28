package anneesBissextiles;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FeatureAnneesBissextiles {
    private int annee;
    private boolean estBissextile;

    @Given("une annee {int}")
    public void une_annee(int annee) {
        this.annee = annee;
    }

    @When("on examine si c'est une année bissextile")
    public void on_examine_si_c_est_une_année_bissextile() {
        estBissextile = AnneesBissextiles.estBissextile(annee);
    }

    @Then("l'année est bissextile : {string}")
    public void l_année_est_bissextile(String estBissextile) {
        assertThat(this.estBissextile).isEqualTo(Boolean.valueOf(estBissextile));
    }
}
