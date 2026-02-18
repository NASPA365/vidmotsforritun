package hi.verkefni.vidmot.controller;

import hi.verkefni.vinnsla.*;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class AdalController {

    @FXML private ListView<Ferd> ferdirListView;

    @FXML
    private void initialize(){
        Ferdaplan ferdaplan = new Ferdaplan(); //býr til ferðirnar í adalview.fxml
        ferdirListView.setItems(ferdaplan.getFerdir()); //tengir observableList
    }


}
