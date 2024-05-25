package steps;

import de.fhkiel.tsw.Gamelogic;
import de.fhkiel.tsw.armyoffrogs.Color;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Und;
import io.cucumber.java.de.Wenn;
import steps.container.LogicContainer;

import static org.assertj.core.api.Assertions.assertThat;


public class MyStepdefs {

    LogicContainer container;
    public MyStepdefs(LogicContainer container) {
        this.container = container;
    }
    Gamelogic logic;
    private int anzahlSpieler;
    private int numofFrogs;

    private boolean gameStarted;

    private Color playerColor;
    private Color frogColor;



    //Testfall 2
    @Angenommen("das Spiel ist mit {int} Spielern  gestartet")
    public void dasSpielIstMitSpielernGestartet(Integer arg0) {
        container.logicUnderTest = new Gamelogic();
        gameStarted = container.logicUnderTest.newGame(arg0);
        System.out.println("Game started: " + gameStarted);
        //throw new io.cucumber.java.PendingException();
    }

    @Wenn("die Anzahl der Spieler abgefragt wird")
    public void dieAnzahlDerSpielerAbgefragtWird() {
        container.logicUnderTest.numberOfPlayers();
    }


    @Dann("wurde das Spiel mit {int} Spieler  gestartet")
    public void wurdeDasSpielMitSpielerAGestartet(Integer arg0) {

        assertThat(container.logicUnderTest.numberOfPlayers()).isEqualTo(arg0);
    }

    @Angenommen("die Anzahl der Spieler {int} ist kleiner als zwei")
    public void dieAnzahlDerSpielerSpielerIstKleinerAlsZwei(Integer arg0) {
        anzahlSpieler = arg0;

    }


    @Wenn("das Spiel gestartet wird")
    public void dasSpielGestartetWird() {
        container.logicUnderTest = new Gamelogic();
        container.logicUnderTest.newGame(anzahlSpieler);
    }

    @Dann("wird das Spiel beendet")
    public void wirdDasSpielBeendet() {
        assertThat(container.logicUnderTest.numberOfPlayers()).isEqualTo(0);
    }

    @Angenommen("die Anzahl der Spieler {int} ist großer als vier")
    public void dieAnzahlDerSpielerSpielerIstGroßerAlsVier(Integer arg0) {
        anzahlSpieler = arg0;

    }

    @Dann("gibt es {int} Spielfarben auf dem Spielfeld")
    public void gibtEsSpielerSpielfarbenAufDemSpielfeld(Integer arg0) {
        assertThat(container.logicUnderTest.numberOfPlayers()).isEqualTo(arg0);
    }

    private void setPlayerColor(String playerColor) {

        switch (playerColor) {
            case "Rot":
                this.playerColor = Color.Red;
                break;
            case "Grün":
                this.playerColor = Color.Green;
                break;
            case "Blau":
                this.playerColor = Color.Blue;
                break;
            case "Schwarz":
                this.playerColor = Color.Black;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + playerColor);
        }


    }

    private void setFrogColor(String frogColor) {

        switch (frogColor) {
            case "Rot":
                this.frogColor = Color.Red;
                break;
            case "Grün":
                this.frogColor = Color.Green;
                break;
            case "Blau":
                this.frogColor = Color.Blue;
                break;
            case "Schwarz":
                this.frogColor = Color.Black;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + frogColor);
        }
    }


    @Wenn("es sind {int} Züge durchgeführt worden gab")
    public void esSindZuegeZügeDurchgeführtWordenGab(Integer arg0) {
        container.logicUnderTest.setGameRound(arg0);
    }
    @Wenn("die Anzahl der Spielsteine von Farbe {int} abgefragt wird")
    public void dieAnzahlDerSpielsteineVonFarbeBeliebigeFarbeAbgefragtWird(Integer arg0) {
        // Write code here that turns the phrase above into concrete actions
        String color = "";
        if(arg0 == 1)
            color = "Rot";
        else if(arg0 == 2)
            color = "Blau";
        else if(arg0 == 3)
            color = "Grün";
        else if(arg0 == 4)
            color = "Schwarz";
        setFrogColor(color);

        numofFrogs = container.logicUnderTest.frogsInBag_withColor(frogColor);
        //container.logicUnderTest.numberOfFrogs(frogColor);

    }

    @Dann("gibt es {int} Spielsteine der Farbe {int}")
    public void gibtEsSpielsteineDerFarbeBeliebigeFarbe(Integer arg0, Integer arg1) {
        assertThat(numofFrogs).isEqualTo(arg0);
    }

    @Wenn("Es wurde kein Spielsteine auf dem Spielfeld gelegt")
    public void es_wurde_kein_spielsteine_auf_dem_spielfeld_gelegt() {
        // Write code here that turns the phrase above into concrete actions
       assertThat(container.logicUnderTest.isFrogonBoard()).isFalse();

    }

    @Wenn("Es wurde kein Spielsteine aus der Beutel gezogen")
    public void es_wurde_kein_spielsteine_aus_der_beutel_gezogen() {
        // Write code here that turns the phrase above into concrete actions
        //assertThat(container.logicUnderTest.frogsInBag()).isEqualTo(40);
        assertThat(container.logicUnderTest.getGameBag().isBagFilled()).isTrue();

    }

    @Wenn("die Anzahl der Spielsteine abgefragt wird")
    public void die_anzahl_der_spielsteine_abgefragt_wird() {
        // Write code here that turns the phrase above into concrete actions
        container.logicUnderTest.frogsInBag();

    }

    @Dann("sind im Beutel {int} Steine")
    public void sind_im_beutel_steine(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertThat(container.logicUnderTest.frogsInBag()).isEqualTo(int1);

    }

}
