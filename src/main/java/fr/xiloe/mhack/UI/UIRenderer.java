package fr.xiloe.mhack.UI;

import fr.xiloe.mhack.Main.Main;
import me.deftware.client.framework.wrappers.render.IFontRenderer;

public class UIRenderer {

    public static void draw() {
        drawClientOverlay();
    }

    public static void drawClientOverlay() {
        // Draw client name at x:0 y:0
        IFontRenderer.drawStringWithShadow(Main.name, 2, 2, 0xFFFFFF);
    }


}
