package dictionnaireRemplacement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FeatureDictionnaireRemplacement {
    private String chaine;
    private Map<String, String> dictionnaire;
    private String resultat;

    @Given("une chaine de caractère {string} avec des clés du dictionnaire {string}")
    public void une_chaine_de_caractère_avec_des_clés_du_dictionnaire(String chaine, String dictionnaire) {
        this.chaine = chaine;
        String[] clesValeurs = dictionnaire.split(",");
        this.dictionnaire = new HashMap<String, String>();
        for (String cleValeur : clesValeurs) {
            String[] cleEtValeur = cleValeur.split(":");
            if (cleEtValeur.length == 2) {
                this.dictionnaire.put(cleEtValeur[0], cleEtValeur[1]);
            }
        }
    }

    @When("on remplace les clés par leur valeur depuis le dictionnaire")
    public void on_remplace_les_clés_par_leur_valeur_depuis_le_dictionnaire() {
        resultat = new DictionnaireRemplacement(dictionnaire).remplacerClesParValeur(chaine);
    }

    @Then("on obtient la chaine de caractère suivante {string}")
    public void on_obtient_la_chaine_de_caractère_suivante(String resultatAttendu) {
        assertThat(this.resultat).isEqualTo(resultatAttendu);
    }
}
