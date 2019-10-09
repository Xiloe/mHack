package fr.xiloe.mhack.Modules.Mods.Movement;

import fr.xiloe.mhack.Main.Main;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.wrappers.IChat;
import me.deftware.client.framework.wrappers.entity.IEntityPlayer;

import java.awt.event.KeyEvent;

public class NoFall extends fr.xiloe.mhack.Modules.Mod {

    public NoFall() {
        super("NoFall", "You can't get damages from falling!", KeyEvent.VK_N);
    }

    @Override
    public void onUpdate(EventUpdate event) {
        if (event != null) {
                // TODO
            }
    }

    @Override
    public void onEnable() {
        // We don't use it.
    }

    @Override
    public void onDisable() {
        // We don't use it.
    }
}
