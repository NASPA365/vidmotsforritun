package hi.verkefni.vinnsla;

import javafx.collections.*;
import java.time.LocalDate;

public class Ferdaplan {

    private final ObservableList<Ferd> ferdir = FXCollections.observableArrayList();

    public Ferdaplan() {
        ferdir.add(new Ferd("chill ferð","sveit", LocalDate.of(2026,3,15)));
        ferdir.add(new Ferd("heimsækja ömmu og afa", "Litháen", LocalDate.of(2026,5,15)));
        ferdir.add(new Ferd("afmælispartí á næsta ári", "Hawaii", LocalDate.of(2027,1,15)));
    }

    public ObservableList<Ferd> getFerdir() {return ferdir;}
}
