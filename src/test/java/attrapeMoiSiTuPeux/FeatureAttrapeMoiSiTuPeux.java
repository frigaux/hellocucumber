package attrapeMoiSiTuPeux;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FeatureAttrapeMoiSiTuPeux {
    private Joueur joueur1;
    private Joueur joueur2;
    private Vision vision;
    private Boolean gagne;

    // Si un joueur avance en dehors du plateau, son déplacement est annulé.
    @Given("un joueur est en bordure : {int}, {int}, {string}")
    public void un_joueur_est_en_bordure(int x, int y, String orientation) {
        joueur1 = new Joueur(x, y, Orientation.valueOf(orientation));
    }

    @When("il avance en dehors du plateau {string}")
    public void il_avance_en_dehors_du_plateau(String nombreCases) {
        joueur1.avancer(Integer.valueOf(nombreCases));
    }

    @Then("son déplacement est annulé : {int}, {int}, {string}")
    public void son_déplacement_est_annulé(int x, int y, String orientation) {
        assertThat(joueur1.x).isEqualTo(x);
        assertThat(joueur1.y).isEqualTo(y);
        assertThat(joueur1.orientation).isEqualTo(Orientation.valueOf(orientation));
    }

    // Si un joueur tourne, sa nouvelle orientation est correcte.
    @Given("un joueur dont l'orientation est {string}")
    public void un_joueur_dont_l_orientation_est(String orientation) {
        joueur1 = new Joueur(0, 0, Orientation.valueOf(orientation));
    }

    @When("il tourne en direction de {string}")
    public void il_tourne_en_direction_de(String direction) {
        joueur1.tourner(Direction.valueOf(direction));
    }

    @Then("sa nouvelle orientation est : {string}")
    public void sa_nouvelle_orientation_est(String nouvelleOrientation) {
        assertThat(joueur1.orientation).isEqualTo(Orientation.valueOf(nouvelleOrientation));
    }

    // Si un joueur avance, sa nouvelle position est correcte.
    @Given("un joueur dont la position est {int}, {int} et l'orientation {string}")
    public void un_joueur_dont_la_position_est_et_l_orientation(int x1, int y1, String orientation) {
        joueur1 = new Joueur(x1, y1, Orientation.valueOf(orientation));
    }

    @When("il avance de {int} cases")
    public void il_avance_de_cases(int nombreCases) {
        joueur1.avancer(nombreCases);
    }

    @Then("son orientation est inchangée {string} et sa nouvelle position est : {int} et {int}")
    public void son_orientation_est_inchangée_et_sa_nouvelle_position_est_et(String orientation, int x2, int y2) {
        assertThat(joueur1.x).isEqualTo(x2);
        assertThat(joueur1.y).isEqualTo(y2);
        assertThat(joueur1.orientation).isEqualTo(Orientation.valueOf(orientation));
    }

    // Le jeu indique si un joueur voit un autre joueur et à combien de cases il se situe.
    // Un joueur ne voit que ce qui se trouve sur la ligne ou la colonne sur laquelle il est orienté.
    @Given("le premier joueur se situe : {int}, {int}, {string}")
    public void le_premier_joueur_se_situe(int x1, int y1, String orientation1) {
        joueur1 = new Joueur(x1, y1, Orientation.valueOf(orientation1));
    }

    @Given("le second joueur se situe : {int}, {int}, {string}")
    public void le_second_joueur_se_situe(int x2, int y2, String orientation2) {
        joueur2 = new Joueur(x2, y2, Orientation.valueOf(orientation2));
    }

    @When("le jeu examine si le premier joueur voit le second")
    public void le_jeu_examine_si_le_premier_joueur_voit_le_second() {
        vision = new Jeu().unJoueurVoitIlUnSecond(joueur1, joueur2);
    }

    @Then("le jeu indique si le premier voit le second et à combien de cases : {string}, {int}")
    public void le_jeu_indique_si_le_premier_voit_le_second_et_à_combien_de_cases(String champDeVision, int nombreCases) {
        assertThat(vision.dansLeChampDeVision()).isEqualTo(Boolean.valueOf(champDeVision));
        assertThat(vision.nombreCases()).isEqualTo(nombreCases);
    }

    // Le jeu indique si un joueur a gagné.
    @Given("le premier joueur se situe : {int} et {int}")
    public void le_premier_joueur_se_situe_et(int x1, int y1) {
        joueur1 = new Joueur(x1, y1, Orientation.NORD);
    }

    @Given("le second joueur se situe : {int} et {int}")
    public void le_second_joueur_se_situe_et(int x2, int y2) {
        joueur2 = new Joueur(x2, y2, Orientation.NORD);
    }

    @When("le jeu examine si le premier joueur a gagné")
    public void le_jeu_examine_si_le_premier_joueur_a_gagné() {
        gagne = new Jeu().unJoueurAGagne(joueur1, joueur2);
    }

    @Then("le jeu renvoie le résultat {string}")
    public void le_jeu_renvoie_le_résultat(String victoirePremierJoueur) {
        assertThat(gagne).isEqualTo(Boolean.valueOf(victoirePremierJoueur));
    }
}
