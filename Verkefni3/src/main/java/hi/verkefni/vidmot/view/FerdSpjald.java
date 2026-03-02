package hi.verkefni.vidmot.view;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FerdSpjald extends javafx.scene.layout.VBox  implements Initializable{

//heiti ferðar ; áfangastað ; dagsetningu

    @FXML private TextField fxheitiFerdar;
    @FXML private TextField fxAfangastadur;
    @FXML private TextField fxDagsetning;

    private final StringProperty heitiProperty = new SimpleStringProperty();
    private final StringProperty afangastadurProperty = new SimpleStringProperty();
    private final StringProperty dagsetningProperty = new SimpleStringProperty();

    public FerdSpjald() {
        URL url = getClass().getResource("ferd-spjald.fxml");
        System.out.println("FXML URL before load: " + url);
        if (url == null) {
            throw new RuntimeException("Move ferd-spjald.fxml to src/main/resources/hi/verkefni/vidmot/view/");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fxheitiFerdar.textProperty().bind(heitiProperty);
        fxAfangastadur.textProperty().bind(afangastadurProperty);
        fxDagsetning.textProperty().bind(dagsetningProperty);
    }


    //intellij getters og setters
    public TextField getFxheitiFerdar() {
        return fxheitiFerdar;
    }

    public void setFxheitiFerdar(TextField fxheitiFerdar) {
        this.fxheitiFerdar = fxheitiFerdar;
    }

    public TextField getFxAfangastadur() {
        return fxAfangastadur;
    }

    public void setFxAfangastadur(TextField fxAfangastadur) {
        this.fxAfangastadur = fxAfangastadur;
    }

    public TextField getFxDagsetning() {
        return fxDagsetning;
    }

    public void setFxDagsetning(TextField fxDagsetning) {
        this.fxDagsetning = fxDagsetning;
    }

    public String getHeitiProperty() {
        return heitiProperty.get();
    }

    public StringProperty heitiProperty() {
        return heitiProperty;
    }

    public String getAfangastadurProperty() {
        return afangastadurProperty.get();
    }

    public StringProperty afangastadurProperty() {
        return afangastadurProperty;
    }

    public String getDagsetningProperty() {
        return dagsetningProperty.get();
    }

    public StringProperty dagsetningProperty() {
        return dagsetningProperty;
    }
}

