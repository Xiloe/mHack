package fr.xiloe.mhack.Main;

import fr.xiloe.mhack.Commands.UtilsCommands;
import fr.xiloe.mhack.Commands.KeybindManager;
import fr.xiloe.mhack.Modules.ModManager;
import fr.xiloe.mhack.UI.UIRenderer;
import me.deftware.client.framework.command.CommandRegister;
import me.deftware.client.framework.event.EventBus;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.*;
import me.deftware.client.framework.main.EMCMod;
import me.deftware.client.framework.network.packets.ICPacketPlayer;
import me.deftware.client.framework.utils.ChatColor;
import me.deftware.client.framework.wrappers.IChat;
import me.deftware.client.framework.wrappers.IMinecraft;
import me.deftware.client.framework.wrappers.gui.IGuiScreen;

public class Main extends EMCMod {

    public static final String PREFIX = ChatColor.RED + "" + ChatColor.BOLD + "mHack" + ChatColor.RESET + "" + ChatColor.GRAY + " >";
    public static final String NAME = "mHack";
    public static final float VERSION = 1.0f;

    private static IGuiScreen screen;
    private static ModManager modmanager = new ModManager();

    @Override
    public void initialize() {
        // Here you initialize anything needed for the mod
        // We need to register this class to handle events
        EventBus.registerClass(this.getClass(), this);
        // We can also register a custom client command here
        CommandRegister.registerCommand(new KeybindManager());
        CommandRegister.registerCommand(new UtilsCommands());
    }

    public static ModManager getModmanager() {
        return modmanager;
    }

    @EventHandler(eventType = EventUpdate.class)
    public void onUpdate(EventUpdate event) {
        if(!modmanager.done) {
            modmanager.initialize();
            modmanager.done = true;
            IChat.sendClientMessage("ModManager: Initialized", Main.PREFIX);
        } else {
            modmanager.onUpdate(event);
        }
    }

    @EventHandler(eventType = EventKeyAction.class)
    public void onKeyAction(EventKeyAction event) {
        if(modmanager.done) {
            modmanager.onKeyAction(event);
        }
    }

    @EventHandler(eventType = EventPacketSend.class)
    public void onPacketSend(EventPacketSend event) {
        if(modmanager.done) {
            modmanager.onPacketSend(event);
        }
    }

    @EventHandler(eventType = EventRender2D.class)
        public void onRender2D(EventRender2D event) {
        if (event != null) {
            if (screen != null) {
                IMinecraft.setGuiScreen(screen);
                screen = null;
            }

            if (UtilsCommands.gui) {
                UIRenderer.draw();
            }
        }
    }
}

