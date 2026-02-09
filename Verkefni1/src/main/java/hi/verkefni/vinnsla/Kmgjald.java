package hi.verkefni.vinnsla;

/**
 * Vinnsluklasi fyrir útreikning á kílómetragjaldi.
 */
public class Kmgjald {

    /**
     * Reiknar ekna kílómetra út frá upphafs- og lokastöðu.
     *
     * @param upphaf Kílómetrastaða í upphafi (>= 0).
     * @param loka Kílómetrastaða í lok (>= 0).
     * @return Fjöldi ekinna kílómetra.
     * @throws IllegalArgumentException Ef upphaf eða loka er neikvætt, eða loka er minni en upphaf.
     */
    public int eknaKm(int upphaf, int loka) {
        if (upphaf < 0 || loka < 0) throw new IllegalArgumentException();
        if (loka < upphaf) throw new IllegalArgumentException();
        return loka - upphaf;
    }

    /**
     * Skilar gjaldi á hvern kílómetra fyrir gefinn gjaldflokk.
     *
     * @param flokkur Gjaldflokkur (A eða C).
     * @return Gjaldið á hvern kílómetra.
     * @throws IllegalArgumentException Ef flokkur er ólöglegur.
     */
    public double gjaldPerKm(String flokkur) {
        String f = flokkur == null ? "" : flokkur.trim().toUpperCase();
        return switch (f) {
            case "A" -> 6.95;
            case "C" -> 4.15;
            default -> throw new IllegalArgumentException();
        };
    }

    /**
     * Reiknar mánaðargjald út frá eknum kílómetrum og gjaldflokki.
     *
     * @param km Eknir kílómetrar.
     * @param flokkur Gjaldflokkur (A eða C).
     * @return Mánaðargjald.
     * @throws IllegalArgumentException Ef flokkur er ólöglegur.
     */
    public double reiknaGjald(int km, String flokkur) {
        return km * gjaldPerKm(flokkur);
    }
}
