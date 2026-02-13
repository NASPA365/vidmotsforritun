package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Leikmadur;
import hi.verkefni.vinnsla.Ludo;
import hi.verkefni.vinnsla.Reitur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class LudoController {
    @FXML private GridPane ludoGrid;
    @FXML private Button teningurButton, nyrButton;
    @FXML private Label hverLabel, reitLabel, teningurLabel;

    
    @FXML private StackPane reit0, reit1, reit2, reit3, reit4, reit5, reit6, reit7, reit8;
    private StackPane[] brautReitir;

    private Ludo ludo;

    public void initialize() {
        brautReitir = new StackPane[]{reit0,reit1,reit2,reit3,reit4,reit5,reit6,reit7,reit8};

        ludo = new Ludo();
        ludo.nyrLeikur();
        syanBraut();  
        updateUI();
        teningurButton.setDisable(false);
        nyrButton.setDisable(true);
    }

    @FXML private void rollTening() {
        boolean lokid = ludo.leikaLeik();
        updateUI();
        if (lokid) {
            teningurButton.setDisable(true);
            nyrButton.setDisable(false);
            hverLabel.setText("🎉 SIGUR! " + ludo.getNuverandiLeikmadurNafn() + " vann!");
        }
    }

    @FXML private void nyrLeikur() {
        ludo.nyrLeikur();
        teningurButton.setDisable(false);
        nyrButton.setDisable(true);
        syanBraut();  
        updateUI();
    }

    private void updateUI() {
        felaPed();


        for (int p = 0; p < 2; p++) {
            int reit = ludo.leikmenn[p].getReitur();
            if (reit < 9) {
                Circle ped = new Circle(p == ludo.current ? 25 : 20);
                ped.setStroke(Color.BLACK);
                ped.setFill(p == 0 ? Color.GREEN : Color.BLUE);
                brautReitir[reit].getChildren().add(ped);
            }
        }

        Leikmadur lm = ludo.getNuverandiLeikmadur();
        hverLabel.setText(lm.getNafn() + " gerir næst");
        reitLabel.setText("Reitur: " + lm.getReitur());

        teningurLabel.setText("Teningur: " + ludo.teningur.getTala());
    }




    private void syanBraut() {
        for (int i = 0; i < 9; i++) {
            StackPane sp = brautReitir[i];

            Circle reitur = new Circle(35);
            reitur.setStroke(Color.BLACK);


            if (i == 0) {
                reitur.setFill(Color.LIGHTGREEN);
            } else if (i == 8) {
                reitur.setFill(Color.ORANGERED);
            } else {
                reitur.setFill(Color.LIGHTBLUE);
            }

            sp.getChildren().setAll(reitur);
        }
    }




    private void hreyfaPed(int reiturNr) {
        felaPed();
        if (reiturNr >= 0 && reiturNr < 9) {
            Circle ped = new Circle(20, Color.BLUE);
            ped.setStroke(Color.DARKBLUE);
            brautReitir[reiturNr].getChildren().add(ped);
        }
    }

    private void felaPed() {
        for (StackPane sp : brautReitir) {

            Circle bak = (Circle) sp.getChildren().get(0);
            if (sp.getChildren().size() > 1) sp.getChildren().remove(1);
        }
    }
}
