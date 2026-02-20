module hi.verkefni.vidmot {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens hi.verkefni.vidmot to javafx.fxml;
    opens hi.verkefni.vidmot.controller to javafx.fxml;
    opens hi.verkefni.vidmot.view to javafx.fxml;  // ADD THIS

    exports hi.verkefni.vidmot;
    exports hi.verkefni.vidmot.view;               // ADD THIS
}
