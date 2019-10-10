package fr.xiloe.mhack.Modules.Mods.Movement;

import me.deftware.client.framework.event.events.EventUpdate;

import java.awt.event.KeyEvent;

public class NoFall extends fr.xiloe.mhack.Modules.Mod {

    public NoFall() {
        super("NoFall", "You can't get damages from falling!", KeyEvent.VK_N);
    }

    @Override
    public void onUpdate(EventUpdate event) {
        // TODO
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
}
