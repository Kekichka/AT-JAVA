package task21;

import org.sikuli.script.Screen;

public class ScreenHelper {
    static void makeScreenShot (){
        new Screen().capture().save(".", "capture_" + System.currentTimeMillis() + ".png");
    }

}
