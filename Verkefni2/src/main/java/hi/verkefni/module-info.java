module hi.verkefni {
    requires javafx.controls;
    requires javafx.fxml;


    opens hi.verkefni to javafx.fxml;
    exports hi.verkefni;
    exports hi.verkefni.vidmot;
    opens hi.verkefni.vidmot to javafx.fxml;
    exports hi.verkefni.vinnsla;
    opens hi.verkefni.vinnsla to javafx.fxml;
}