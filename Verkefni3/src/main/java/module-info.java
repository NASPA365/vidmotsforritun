module hi.verkefni.vidmot {
    requires javafx.controls;
    requires javafx.fxml;

    opens hi.verkefni.vidmot to javafx.fxml;
    opens hi.verkefni.vidmot.controller to javafx.fxml;
    exports hi.verkefni.vidmot;

}
