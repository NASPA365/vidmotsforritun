package hi.verkefni.vinnsla;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Ferd {

//heiti ferðar ; áfangastað ; dagsetningu

    private final StringProperty heitiFerdar = new SimpleStringProperty();
    private final StringProperty afangastadur = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> dagsetning = new SimpleObjectProperty<>();

    public Ferd(String heitiFerdar, String afangastadur, LocalDate dagsetning) {
        this.heitiFerdar.set(heitiFerdar);
        this.afangastadur.set(afangastadur);
        this.dagsetning.set(dagsetning);
    }

    //generated getters frá intellij
    public String getHeitiFerdar() {
        return heitiFerdar.get();
    }
    public StringProperty heitiFerdarProperty() {
        return heitiFerdar;
    }

    public String getAfangastadur() {
        return afangastadur.get();
    }
    public StringProperty afangastadurProperty() {
        return afangastadur;
    }

    public LocalDate getDagsetning() {
        return dagsetning.get();
    }
    public ObjectProperty<LocalDate> dagsetningProperty() {
        return dagsetning;
    }

    @Override
    public String toString() {
        return getHeitiFerdar() + " - " + getAfangastadur() + " - " + getDagsetning();
    }
}
