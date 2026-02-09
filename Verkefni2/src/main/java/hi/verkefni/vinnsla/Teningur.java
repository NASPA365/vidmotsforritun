package hi.verkefni.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

public class Teningur {

    private static final int MAX = 6;
    private final IntegerProperty tala = new SimpleIntegerProperty(MAX);
    private final Random random = new Random();

    @Override
    public String toString() {
        return "Teningur{" +
                "random=" + random +
                '}';
    }

    /**
     * Kastar tening þannig að fundinn sé tala af handahófi á bilinu 1 til MAX+1
     */
    public void kasta() {

        tala.set(random.nextInt(MAX) + 1);
    }

    public int getTala() {
        return tala.get();
    }

    public IntegerProperty talaProperty() {
        return tala;
    }

    /**
     * main aðferð sem prentar tölu af handófi frá bilinu 1-6
     */
    public static void main(String[] args) {
        Teningur t = new Teningur();
        t.kasta();
        System.out.println(t);
    }
}

