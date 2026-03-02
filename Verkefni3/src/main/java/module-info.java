module hi.verkefni.vidmot {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens hi.verkefni.vidmot to javafx.fxml;
    opens hi.verkefni.vidmot.controller to javafx.fxml;
    exports hi.verkefni.vidmot;

}


/* ef þarf:
    module your.module.name {
    requires javafx.controls;
    requires javafx.fxml;

    exports is.vidmot;
    opens is.vidmot to javafx.fxml;
    exports is.vidmot.controller;
    opens is.vidmot.controller to javafx.fxml;
    exports is.vidmot.view;
    opens is.vidmot.view to javafx.fxml;
    exports is.vinnsla;
    opens is.vinnsla to javafx.fxml;
}
*/