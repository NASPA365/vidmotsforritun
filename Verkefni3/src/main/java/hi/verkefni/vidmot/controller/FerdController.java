package hi.verkefni.vidmot.controller;

import hi.verkefni.vidmot.switcher.View;
import hi.verkefni.vidmot.switcher.ViewSwitcher;
import hi.verkefni.vidmot.view.FerdSpjald;  // Add this import
import hi.verkefni.vinnsla.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FerdController implements GognInterface<Ferd> {

    @FXML private Button tilBakaBtn;
    @FXML private FerdSpjald fxFerdSpjald;  // New field replaces old TextAreas

    @Override
    public void setGogn(Ferd f) {
        if (f != null) {
            // Bind Ferd data to FerdSpjald properties
            fxFerdSpjald.heitiFerdarProperty().bind(f.heitiFerdarProperty());
            fxFerdSpjald.afangastadurProperty().bind(f.afangastadurProperty());
            fxFerdSpjald.dagsetningProperty().bind(f.dagsetningProperty());
        }
    }

    @FXML private void handleTilBaka() {
        ViewSwitcher.switchTo(View.ADAL);
    }
}
