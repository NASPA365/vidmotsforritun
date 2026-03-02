package hi.verkefni.vidmot.controller;

import hi.verkefni.vidmot.switcher.View;
import hi.verkefni.vidmot.switcher.ViewSwitcher;
import hi.verkefni.vidmot.view.FerdSpjald;
import hi.verkefni.vinnsla.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;


public class FerdController implements GognInterface<Ferd> {

    @FXML private Button tilBakaBtn;
    @FXML private FerdSpjald fxFerdSpjald;

    @Override
    public void setGogn(Ferd f) {
        System.out.println("setGogn: " + (f != null ? f.toString() : "null"));
        if (f != null) {
            fxFerdSpjald.heitiProperty().bind(f.heitiFerdarProperty());
            fxFerdSpjald.afangastadurProperty().bind(f.afangastadurProperty());
            fxFerdSpjald.dagsetningProperty().bind(f.dagsetningProperty());
        }
    }

    @FXML private void handleTilBaka() {
        ViewSwitcher.switchTo(View.ADAL);
    }
}

