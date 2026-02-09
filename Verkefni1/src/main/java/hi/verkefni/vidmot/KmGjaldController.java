package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import hi.verkefni.vinnsla.Kmgjald;

/**
 * Stýriklasi (controller) fyrir Kmgjald-view.fxml.
 * Tekur við atburðum frá notendaviðmóti og uppfærir reiti.
 */
public class KmgjaldController {

    private final Kmgjald vinnsla = new Kmgjald();

    @FXML private TextField fjoldiManadaField;
    @FXML private TextField flokkurField;
    @FXML private TextField gjaldPerKmField;
    @FXML private TextField heildGjaldField;
    @FXML private TextField heildKmField;
    @FXML private Button hreinsaBtn;
    @FXML private TextField lokaKmField;
    @FXML private TextField manGjaldField;
    @FXML private TextField manKmField;
    @FXML private Button skraBtn;
    @FXML private TextField upphafKmField;
    @FXML private Button skraManBtn;

    /**
     * Bregst við þegar notandi uppfærir gjaldflokk (Enter í flokksreit).
     *
     * @param event Atburður frá viðmótinu.
     */
    @FXML
    private void onFlokkurField(ActionEvent event) {
        String f = flokkurField.getText().trim().toUpperCase();
        flokkurField.getStyleClass().remove("rangt-inntak");

        if (f.equals("A")) {
            gjaldPerKmField.setText("6.59");
        } else if (f.equals("C")) {
            gjaldPerKmField.setText("4.15");
        } else {
            gjaldPerKmField.setText("");
            if (!flokkurField.getStyleClass().contains("rangt-inntak")) {
                flokkurField.getStyleClass().add("rangt-inntak");
            }
        }
    }

    /**
     * Bregst við þegar notandi slær inn upphafsstöðu (Enter).
     *
     * @param event Atburður frá viðmótinu.
     */
    @FXML
    void onUpphafsKmField(ActionEvent event) {
        upphafKmField.getStyleClass().remove("rangt-inntak");

        try {
            int upphaf = Integer.parseInt(upphafKmField.getText());
            if (upphaf < 0) {
                throw new IllegalArgumentException("Kílómetrafjöldi getur ekki verið neikvæður!");
            }
        } catch (NumberFormatException e) {
            if (!upphafKmField.getStyleClass().contains("rangt-inntak")) {
                upphafKmField.getStyleClass().add("rangt-inntak");
            }
        } catch (IllegalArgumentException e) {
            if (!upphafKmField.getStyleClass().contains("rangt-inntak")) {
                upphafKmField.getStyleClass().add("rangt-inntak");
            }
        }
    }

    /**
     * Bregst við þegar notandi slær inn lokastöðu (Enter).
     *
     * @param event Atburður frá viðmótinu.
     */
    @FXML
    void onLokaKmField(ActionEvent event) {
        lokaKmField.getStyleClass().remove("rangt-inntak");
        upphafKmField.getStyleClass().remove("rangt-inntak");

        try {
            int upphaf = Integer.parseInt(upphafKmField.getText());
            int loka = Integer.parseInt(lokaKmField.getText());

            if (upphaf < 0) {
                upphafKmField.getStyleClass().add("rangt-inntak");
                return;
            }
            if (loka < 0) {
                lokaKmField.getStyleClass().add("rangt-inntak");
                return;
            }
            if (loka < upphaf) {
                lokaKmField.getStyleClass().add("rangt-inntak");
                return;
            }
        } catch (NumberFormatException e) {
            lokaKmField.getStyleClass().add("rangt-inntak");
        }
    }

    /**
     * Reiknar og birtir eknu kílómetrana og gjald fyrir núverandi skráningu.
     *
     * @param event Atburður frá viðmótinu.
     */
    @FXML
    private void onSkraBtn(ActionEvent event) {
        try {
            int upphaf = Integer.parseInt(upphafKmField.getText());
            int loka = Integer.parseInt(lokaKmField.getText());
            String flokkur = flokkurField.getText().trim().toUpperCase();

            int eknaKm = vinnsla.eknaKm(upphaf, loka);
            double manGjald = vinnsla.reiknaGjald(eknaKm, flokkur);

            long manGjaldRounded = Math.round(manGjald);

            manGjaldField.setText(manGjaldRounded + " kr");
            manKmField.setText(eknaKm + " km");

            manKmField.setText(String.valueOf(eknaKm));
            manGjaldField.setText(String.format("%.2f", manGjald));
        } catch (NumberFormatException e) {
        } catch (IllegalArgumentException e) {
        }

        String f = flokkurField.getText().trim().toUpperCase();
        String u = upphafKmField.getText().trim();
        String l = lokaKmField.getText().trim();

        if (f.isEmpty() || u.isEmpty() || l.isEmpty()) {
            return;
        }

        flokkurField.clear();
        upphafKmField.clear();
        lokaKmField.clear();
        gjaldPerKmField.clear();

        flokkurField.getStyleClass().remove("rangt-inntak");
        upphafKmField.getStyleClass().remove("rangt-inntak");
        lokaKmField.getStyleClass().remove("rangt-inntak");
    }

    /**
     * Hreinsar inntaksreiti fyrir núverandi skráningu án þess að breyta heildartölum.
     *
     * @param event Atburður frá viðmótinu.
     */
    @FXML
    private void onHreinsaBtn(ActionEvent event) {
        flokkurField.clear();
        upphafKmField.clear();
        lokaKmField.clear();
        gjaldPerKmField.clear();
        manKmField.clear();
        manGjaldField.clear();

        flokkurField.getStyleClass().remove("rangt-inntak");
        upphafKmField.getStyleClass().remove("rangt-inntak");
        lokaKmField.getStyleClass().remove("rangt-inntak");
        manGjaldField.getStyleClass().remove("rangt-inntak");
    }

    /**
     * Skráir mánuð og uppfærir heildartölur meðan forritið er í keyrslu.
     *
     * @param event Atburður frá viðmótinu.
     */
    @FXML
    private void onSkraMan(ActionEvent event) {

        manKmField.getStyleClass().remove("rangt-inntak");
        manGjaldField.getStyleClass().remove("rangt-inntak");

        try {
            String manKmTxt = manKmField.getText().trim();
            String manGjaldTxt = manGjaldField.getText().trim();

            if (manKmTxt.isEmpty() || manGjaldTxt.isEmpty()) {
                throw new IllegalArgumentException("Vantar mán. km/gjald");
            }

            int manKm = Integer.parseInt(manKmTxt);
            double manGjald = Double.parseDouble(manGjaldTxt.replace(',', '.'));

            int heildKm = 0;
            if (!heildKmField.getText().trim().isEmpty()) {
                heildKm = Integer.parseInt(heildKmField.getText().trim());
            }

            double heildGjald = 0.0;
            if (!heildGjaldField.getText().trim().isEmpty()) {
                heildGjald = Double.parseDouble(heildGjaldField.getText().trim().replace(',', '.'));
            }

            int fjoldi = 0;
            if (!fjoldiManadaField.getText().trim().isEmpty()) {
                fjoldi = Integer.parseInt(fjoldiManadaField.getText().trim());
            }

            heildKm += manKm;
            heildGjald += manGjald;
            fjoldi++;

            heildKmField.setText(String.valueOf(heildKm));
            heildGjaldField.setText(String.format("%.2f", heildGjald));
            fjoldiManadaField.setText(String.valueOf(fjoldi));

            manKmField.clear();
            manGjaldField.clear();

        } catch (Exception e) {
        }
    }

}
