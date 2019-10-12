package fr.xiloe.mhack.UI;

import fr.xiloe.mhack.Commands.UtilsCommands;
import fr.xiloe.mhack.Main.Main;
import fr.xiloe.mhack.Modules.Mod;
import me.deftware.client.framework.wrappers.IMinecraft;
import me.deftware.client.framework.wrappers.entity.IEntityPlayer;
import me.deftware.client.framework.wrappers.gui.IGuiScreen;
import me.deftware.client.framework.wrappers.render.IFontRenderer;

public class UIRenderer {

    public static void draw() {
        drawClientOverlay();
    }

    private static void drawClientOverlay() {
        // Client name & version (Top left corner)
        IFontRenderer.drawStringWithShadow(Main.NAME, 2, 2, 0x55FFFF);
        IFontRenderer.drawStringWithShadow(String.valueOf(Main.VERSION), IFontRenderer.getStringWidth(Main.NAME + 1), 2, 0xFFFFFF);

        // FPS (Top left corner)
        IFontRenderer.drawStringWithShadow("FPS:", 2, 10 + IFontRenderer.getFontHeight(), 0x55FFFF);
        IFontRenderer.drawStringWithShadow(String.valueOf(IMinecraft.getFPS()), IFontRenderer.getStringWidth("FPS:" + 1), 10 + IFontRenderer.getFontHeight(), 0xFFFFFF);

        // TODO: Make this working
        // TPS (Top left corner)
        IFontRenderer.drawStringWithShadow("TPS:", 2, 12 + IFontRenderer.getFontHeight() * 2, 0x55FFFF);
        IFontRenderer.drawStringWithShadow("N/A", IFontRenderer.getStringWidth("TPS:" + 1), 12 + IFontRenderer.getFontHeight() * 2, 0xFFFFFF);

        // TODO: Working?
        // Ping (Top left corner)
        IFontRenderer.drawStringWithShadow("Ping:", 2, 12 + IFontRenderer.getFontHeight() * 3, 0x55FFFF);
        IFontRenderer.drawStringWithShadow(String.valueOf(IMinecraft.getCurrentServer().getIPingToServer()), IFontRenderer.getStringWidth("Ping:" + 1), 12 + IFontRenderer.getFontHeight() * 3, 0xFFFFFF);

        int y = 0;
        if (UtilsCommands.coordinates) {
            y = IGuiScreen.getScaledHeight() - IFontRenderer.getFontHeight() * 2 - 4;
        } else {
            y = y = IGuiScreen.getScaledHeight() - IFontRenderer.getFontHeight() - 2;
        }

        // Current server IP + game version (Bottom left corner)
        IFontRenderer.drawStringWithShadow("IP:", 2, y, 0x55FFFF);
        IFontRenderer.drawStringWithShadow(IMinecraft.getCurrentServer().getIIP() + " [" + IMinecraft.getCurrentServer().getIGameVersion() + "]", IFontRenderer.getStringWidth("IP:" + 1), y, 0xFFFFFF);

        if (UtilsCommands.coordinates) {
            // Coordinates (Bottom left corner)
            IFontRenderer.drawStringWithShadow("XYZ:", 2, IGuiScreen.getScaledHeight() - IFontRenderer.getFontHeight() - 2, 0x55FFFF);
            IFontRenderer.drawStringWithShadow((int) IEntityPlayer.getPosX() + ", " + (int) IEntityPlayer.getPosY() + ", " + (int) IEntityPlayer.getPosZ(), IFontRenderer.getStringWidth("XYZ:" + 1), IGuiScreen.getScaledHeight() - IFontRenderer.getFontHeight() - 2, 0xFFFFFF);
        }

        //Render all active Mods
        int i = 1;

        IFontRenderer.drawStringWithShadow("Active modules:", IGuiScreen.getScaledWidth() - IFontRenderer.getStringWidth("Active Modules:") - 2, 2, 0xFFFFFF);
        for (Mod m : Main.getModmanager().getModlist().values()) {
            if (m.isState()) {
                int offset = 0;
                offset = (IFontRenderer.getFontHeight() * i);
                IFontRenderer.drawStringWithShadow(m.getName(),
                        IGuiScreen.getScaledWidth() - IFontRenderer.getStringWidth(m.getName()) - 2,
                        3 + offset, 0x00AAAA);
                i += 1;
            }
        }
    }
}
