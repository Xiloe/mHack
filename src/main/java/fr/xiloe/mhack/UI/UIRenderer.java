package fr.xiloe.mhack.UI;

import fr.xiloe.mhack.Main.Main;
import fr.xiloe.mhack.Modules.Mod;
import me.deftware.client.framework.wrappers.IMinecraft;
import me.deftware.client.framework.wrappers.entity.IEntityPlayer;
import me.deftware.client.framework.wrappers.gui.IGuiScreen;
import me.deftware.client.framework.wrappers.render.IFontRenderer;
import net.minecraft.server.MinecraftServer;


public class UIRenderer {

    public static void draw() {
        drawClientOverlay();
    }

    private static void drawClientOverlay() {
        IFontRenderer.drawStringWithShadow(Main.name + " - v" + Main.version, 2, 2, 0xFF0000);

        IFontRenderer.drawStringWithShadow("Modules: ", 2, 10 + IFontRenderer.getFontHeight()*1, 0xFFFFFF);
        IFontRenderer.drawStringWithShadow(String.valueOf(Main.getModmanager().getModlist().size()), IFontRenderer.getStringWidth("Modules: "), 10 + IFontRenderer.getFontHeight()*1, 0x999999);

        IFontRenderer.drawStringWithShadow("FPS: ", 2, 10 + IFontRenderer.getFontHeight()*2, 0xFFFFFF);
        IFontRenderer.drawStringWithShadow(String.valueOf(IMinecraft.getFPS()), IFontRenderer.getStringWidth("FPS: "), 10 + IFontRenderer.getFontHeight()*2, 0x999999);

        // TODO: Fix it
        IFontRenderer.drawStringWithShadow("XYZ: ", 2, IGuiScreen.getDisplayHeight() - IFontRenderer.getFontHeight() - 2, 0xFFFFFF);
        IFontRenderer.drawStringWithShadow(String.valueOf(IEntityPlayer.getPosX() + ", " + IEntityPlayer.getPosY() + ", " + IEntityPlayer.getPosZ()), IFontRenderer.getStringWidth("XYZ: "), IGuiScreen.getDisplayHeight() - IFontRenderer.getFontHeight() - 2, 0x999999);


        int i = 0;
        for (Mod m : Main.getModmanager().getModlist().values()) {
            if (m.isState()) {
                int offset = 0;
                offset = (IFontRenderer.getFontHeight() * i);
                IFontRenderer.drawStringWithShadow(m.getName(),
                        IGuiScreen.getScaledWidth() - IFontRenderer.getStringWidth(m.getName()) - 2,
                        3 + offset, 0xE69138);
                i += 1;
            }
        }
    }


}
