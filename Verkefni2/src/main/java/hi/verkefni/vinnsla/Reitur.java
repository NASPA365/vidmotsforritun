package hi.verkefni.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

enum Tegund {
    BYRJUN,
    VENJULEGT,
    MARK
}

public class Reitur {
    private final IntegerProperty row = new SimpleIntegerProperty();
    private final IntegerProperty col = new SimpleIntegerProperty();
    private final ObjectProperty<Tegund> tegund = new SimpleObjectProperty<>(Tegund.VENJULEGT);

    public Reitur(int row, int col, Tegund tegund) {
        this.row.set(row);
        this.col.set(col);
        this.tegund.set(tegund);
    }

    public int getRow() {
        return row.get();}
    public IntegerProperty rowProperty() {
        return row;
    }
    public int getCol() {
        return col.get();
    }
    public IntegerProperty colProperty() {
        return col;
    }
    public Tegund getTegund() {
        return tegund.get();
    }
    public ObjectProperty<Tegund> tegundProperty() {
        return tegund;
    }

    @Override
    public String toString() {
        return "Reitur{" +
                "tegund=" + tegund +
                ", col=" + col +
                ", row=" + row +
                '}';
    }

    public static void main() {
        Reitur byrjun = new Reitur(0, 0, Tegund.BYRJUN);
        Reitur mark = new Reitur(4, 4, Tegund.MARK);
        Reitur venjulegur = new Reitur(2, 2, Tegund.VENJULEGT);
    }
}
