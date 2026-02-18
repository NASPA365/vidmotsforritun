package hi.verkefni.vidmot.controller;

import hi.verkefni.vidmot.switcher.View;
import hi.verkefni.vidmot.switcher.ViewSwitcher;
import hi.verkefni.vinnsla.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;


public class FerdController implements GognInterface<Ferd> {

    @FXML private Button tilBakaBtn;
    @FXML private TextArea heitiTextArea, stadurTextArea, dagsetningTextArea ;

    @Override
    public void setGogn(Ferd ferd) {
        if (ferd != null) {
            heitiTextArea.setText(ferd.getHeitiFerdar());
            stadurTextArea.setText(ferd.getAfangastadur());
            dagsetningTextArea.setText(ferd.getDagsetning().toString());
        }
    }

    @FXML private void handleTilBaka() {
        ViewSwitcher.switchTo(View.ADAL);
    }
}

