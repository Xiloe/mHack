package fr.xiloe.mhack.Modules.Mods.Movement;

import fr.xiloe.mhack.Modules.Mod;
import me.deftware.client.framework.event.events.EventDamage;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.wrappers.entity.IEntityPlayer;

import java.awt.event.KeyEvent;

public class Flight extends Mod {


    public Flight() {
        super("Flight", "I believe I can fly!", KeyEvent.VK_R);
    }

    @Override
    public void onUpdate(EventUpdate event) {
        if (event != null) {
            IEntityPlayer.setFlying(true);
        }
    }

    @Override
    public void onPacketSend(EventPacketSend event) {

    }

    @Override
    public void onDamage(EventDamage event) {

    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {
        IEntityPlayer.setFlying(false);
    }
}
