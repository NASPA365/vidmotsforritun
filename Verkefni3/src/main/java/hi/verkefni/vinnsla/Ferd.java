package hi.verkefni.vinnsla;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Ferd {

//heiti ferðar ; áfangastað ; dagsetningu

    private final StringProperty heitiFerdar = new SimpleStringProperty();
    private final StringProperty afangastadur = new SimpleStringProperty();
    private final StringProperty dagsetning = new SimpleStringProperty();

    public Ferd(String heitiFerdar, String afangastadur, String dagsetning) {
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

    public String getDagsetning() {
        return dagsetning.get();
    }
    public StringProperty dagsetningProperty() {
        return dagsetning;
    }

    @Override
    public String toString() {
        return getHeitiFerdar() + " || " + getAfangastadur() + " || " + getDagsetning();
    }
}
