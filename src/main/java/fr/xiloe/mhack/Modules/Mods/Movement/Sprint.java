package fr.xiloe.mhack.Modules.Mods.Movement;

import fr.xiloe.mhack.Modules.Mod;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.wrappers.entity.IEntityPlayer;

import java.awt.event.KeyEvent;

public class Sprint extends Mod {

    public Sprint() {
        super("Sprint", "Sprint every time you walk", KeyEvent.VK_B);
    }

    @Override
    public void onUpdate(EventUpdate event) {
        if (event != null) {
            IEntityPlayer.setSprinting(true);
        }
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {
        IEntityPlayer.setSprinting(false);
    }
}
