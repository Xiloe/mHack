package fr.xiloe.mhack.Main;

import fr.xiloe.mhack.Commands.TestCommands;
import fr.xiloe.mhack.Modules.ModManager;
import fr.xiloe.mhack.UI.UIRenderer;
import me.deftware.client.framework.event.*;
import me.deftware.client.framework.command.*;
import me.deftware.client.framework.main.EMCMod;
import me.deftware.client.framework.event.events.*;
import me.deftware.client.framework.utils.ChatColor;
import me.deftware.client.framework.wrappers.IChat;
import me.deftware.client.framework.wrappers.IMinecraft;
import me.deftware.client.framework.wrappers.gui.IGuiScreen;

public class Main extends EMCMod {

    public static final String prefix = ChatColor.RED + "mHack" + ChatColor.GRAY + " >";
    public static final String name = "mHack";
    public static final float version = 1.0f;

    private static IGuiScreen screen;
    private static ModManager modmanager = new ModManager();

    @Override
    public void initialize() {
        // Here you initialize anything needed for the mod
        // We need to register this class to handle events
        EventBus.registerClass(this.getClass(), this);
        // We can also register a custom client command here
        CommandRegister.registerCommand(new TestCommands());
    }

    public static ModManager getModmanager() {
        return modmanager;
    }

    @EventHandler(eventType = EventUpdate.class)
    public void onUpdate(EventUpdate event) {
        if(!modmanager.done) {
            modmanager.initialize();
            modmanager.done = true;
            IChat.sendClientMessage("ModManager: Initialized", Main.prefix);
        } else {
            modmanager.onUpdate(event);
        }
    }

    @EventHandler(eventType = EventKeyAction.class)
    public void onUp(EventKeyAction event) {
        if(modmanager.done) {
            modmanager.onKeyAction(event);
        }
    }

    @EventHandler(eventType = EventRender2D.class)
        public void onRender2D(EventRender2D event) {
        if (event != null) {
            if (screen != null) {
                IMinecraft.setGuiScreen(screen);
                screen = null;
            }
            UIRenderer.draw();
        }
    }
}

