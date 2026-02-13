package hi.verkefni.vinnsla;

import hi.verkefni.vinnsla.Reitur;

import hi.verkefni.vidmot.LudoApplication;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.List;

enum Leikstada { ACTIVE, FINISHED}

public class Ludo {
    public Leikmadur[] leikmenn = {new Leikmadur("Grænn"), new Leikmadur("Blár")};
    ArrayList<Reitur> leid = new ArrayList<>();
    public Teningur teningur = new Teningur();
    public int current = 0;
    SimpleObjectProperty<Leikstada> stada = new SimpleObjectProperty<>(Leikstada.ACTIVE);

    public Ludo() {
        leid.add(new Reitur(0, 1, Tegund.BYRJUN));
        leid.add(new Reitur(1, 1, Tegund.VENJULEGT));
        leid.add(new Reitur(2, 1, Tegund.VENJULEGT));
        leid.add(new Reitur(3, 1, Tegund.VENJULEGT));
        leid.add(new Reitur(2, 3, Tegund.VENJULEGT));
        leid.add(new Reitur(3, 3, Tegund.VENJULEGT));
        leid.add(new Reitur(3, 2, Tegund.VENJULEGT));
        leid.add(new Reitur(3, 1, Tegund.VENJULEGT));
        leid.add(new Reitur(1, 4, Tegund.MARK));
    }

    public void nyrLeikur() {
        leikmenn[0].setReitur(0);
        leikmenn[1].setReitur(0);
        current = 0;
        stada.set(Leikstada.ACTIVE);
    }

    public boolean leikaLeik() {
        teningur.kasta();
        int kast = teningur.getTala();

        leikmenn[current].faera(kast, 8);
        int nyReit = leikmenn[current].getReitur();

        for (int o = 0; o < 2; o++) {
            if (o != current && leikmenn[o].getReitur() == nyReit) {
                leikmenn[o].setReitur(0);
                System.out.println(leikmenn[o].getNafn() + " sendur heim!");
            }
        }

        if (nyReit == 8) return true;

        current = 1 - current;
        return false;
    }


    public Leikmadur getNuverandiLeikmadur() {
        return leikmenn[current];
    }

    public String getNuverandiLeikmadurNafn() {
        return leikmenn[current].getNafn();
    }

    public List<Reitur> getLeid() {
        return leid;
    }

    public static void main(String[] args) {
        Ludo ludo = new Ludo();
        ludo.nyrLeikur();

        System.out.println("Leikur byrjar");

        while (true) {
            Leikmadur lm = ludo.leikmenn[ludo.current];
            System.out.println(lm.getNafn() + " á reit " + lm.getReitur());

            boolean lokid = ludo.leikaLeik();
            System.out.println("Teningur: " + ludo.teningur.getTala());

            if (lokid) {
                System.out.println(lm.getNafn() + " vann!");
                break;
            }
        }
    }
}


