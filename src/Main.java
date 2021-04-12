import java.awt.*;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        Window appWindow = null;
        try {
            appWindow = new Window();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        appWindow.setVisible(true);
    }
}
