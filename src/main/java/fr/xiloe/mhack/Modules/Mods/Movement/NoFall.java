package fr.xiloe.mhack.Modules.Mods.Movement;

import me.deftware.client.framework.event.events.EventDamage;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.wrappers.IChat;

import java.awt.event.KeyEvent;

public class NoFall extends fr.xiloe.mhack.Modules.Mod {

    public NoFall() {
        super("NoFall", "You can't get damages from falling!", KeyEvent.VK_N);
    }

    @Override
    public void onUpdate(EventUpdate event) {

    }

    @Override
    public void onPacketSend(EventPacketSend event) {

    }

    // TODO: Find a solution, this is broken
    @Override
    public void onDamage(EventDamage event) {
        IChat.sendClientMessage("Damaged by " + event.getSource());
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
}
