package hi.verkefni.vidmot.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Endurnýtanlegur custom component til að birta upplýsingar um Ferð.
 */
public class FerdSpjald extends VBox implements Initializable {

    @FXML private TextField fxHeitiFerdar;
    @FXML private TextField fxAfangastadur;
    @FXML private TextField fxDagsetning;

    private final StringProperty heitiFerdarProperty = new SimpleStringProperty(this, "heitiFerdar");
    private final StringProperty afangastadurProperty = new SimpleStringProperty(this, "afangastadur");
    private final StringProperty dagsetningProperty = new SimpleStringProperty(this, "dagsetning");

    // Smiður: load FXML
    public FerdSpjald() {
        URL url = getClass().getResource("/hi/verkefni/vidmot/ferd-spjald.fxml");
        System.out.println("FXML path: " + url);
        if (url == null) {
            System.out.println("FXML finnst EKKI!");
            return;
        }

        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(this);

        try {
            VBox fxmlRoot = loader.load();  // Load VBox directly
            this.getChildren().add(fxmlRoot);  // Add as child of this VBox
            System.out.println("FXML LOADED OK!");
        } catch (IOException e) {
            System.out.println("LOAD VILLA: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Bind TextFields to properties (bidirectional)
        fxHeitiFerdar.textProperty().bindBidirectional(heitiFerdarProperty);
        fxAfangastadur.textProperty().bindBidirectional(afangastadurProperty);
        fxDagsetning.textProperty().bindBidirectional(dagsetningProperty);
    }

    // Public properties for external binding (e.g., from FerdController)
    public StringProperty heitiFerdarProperty() { return heitiFerdarProperty; }
    public StringProperty afangastadurProperty() { return afangastadurProperty; }
    public StringProperty dagsetningProperty() { return dagsetningProperty; }

    // Optional setters for direct updates
    public void setHeitiFerdar(String value) { heitiFerdarProperty.set(value); }
    public void setAfangastadur(String value) { afangastadurProperty.set(value); }
    public void setDagsetning(String value) { dagsetningProperty.set(value); }
}
