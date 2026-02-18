package hi.verkefni.vidmot.switcher;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 *
 * viðbætur fyrir Ferdaplan verkefni
 */
public enum View {
    ADAL("/hi/verkefni/vidmot/adal-view.fxml"),
    FERD("/hi/verkefni/vidmot/ferd-view.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
