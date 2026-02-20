package hi.verkefni.vinnsla;

import javafx.collections.*;
import java.time.LocalDate;

public class Ferdaplan {

    private final ObservableList<Ferd> ferdir = FXCollections.observableArrayList();

    public Ferdaplan() {
        ferdir.add(new Ferd("chill ferð","sveit", "ár"));
        ferdir.add(new Ferd("heimsækja ömmu og afa", "Litháen", "ár"));
        ferdir.add(new Ferd("afmælispartí á næsta ári", "Hawaii", "ár"));
    }

    public ObservableList<Ferd> getFerdir() {return ferdir;}
}
