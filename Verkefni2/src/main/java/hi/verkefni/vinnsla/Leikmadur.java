package hi.verkefni.vinnsla;

import javafx.application.Application;
import javafx.beans.property.*;

public class Leikmadur {
    private final SimpleStringProperty nafn;
    private final SimpleIntegerProperty reitur;
    public String getNafn;

    public Leikmadur(String nafn) {
        this.nafn = new SimpleStringProperty(nafn);
        this.reitur = new SimpleIntegerProperty(0);
    }


    /**
     * Færir peð leikmanns um i sæti en þó aldrei fram yfir max
     * @param i sæti sem á að færa peðið fram um
     * @param max hæsta sæti
     */
    public void faera(int i, int max) {
        int newReitur = reitur.get() + i;
        if (newReitur > max) {
            newReitur = max;
        }
        reitur.set(newReitur);
    }

    public SimpleStringProperty nafnProperty() {return nafn;}

    public SimpleIntegerProperty reiturProperty() {return reitur;}

    @Override
    public String toString()
    {
        return nafn.get() + " " + reitur.get();
    }

    public int getReitur() {
        return reitur.get();
    }

    public void setReitur(int newReitur) {
        reitur.set(newReitur);
    }

    public String getNafn() {
        return nafn.get();
    }

    public static class Main {
        public static void main(String[] args) {
            Leikmadur leikmadur = new Leikmadur("Jón");

            System.out.println(leikmadur);  
            leikmadur.faera(12, 24);        
            System.out.println(leikmadur);  

            leikmadur.faera(15, 24);        
            System.out.println(leikmadur);  
        }
    }

}
