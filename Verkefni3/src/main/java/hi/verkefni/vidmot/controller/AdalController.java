package hi.verkefni.vidmot.controller;

import hi.verkefni.vidmot.switcher.View;
import hi.verkefni.vidmot.switcher.ViewSwitcher;
import hi.verkefni.vinnsla.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdalController {

    @FXML private ListView<Ferd> ferdirListView;
    @FXML private Button skodaBtn, eydaBtn;

    @FXML
    private void initialize(){
        Ferdaplan ferdaplan = new Ferdaplan(); //býr til ferðirnar í adalview.fxml
        ferdirListView.setItems(ferdaplan.getFerdir()); //tengir observableList

        //takka function
        skodaBtn.disableProperty().bind(ferdirListView.getSelectionModel().selectedItemProperty().isNull());
        eydaBtn.disableProperty().bind(ferdirListView.getSelectionModel().selectedItemProperty().isNull());

        //svo að takkinn tengist við handleSkoda
        skodaBtn.setOnAction(e -> {handleSkoda();});
    }


    @FXML private void handleSkoda() {
        Ferd valin = ferdirListView.getSelectionModel().getSelectedItem();
        ViewSwitcher.switchTo(View.FERD, false, valin);
    }

}
