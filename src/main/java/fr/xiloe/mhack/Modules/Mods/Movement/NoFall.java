package fr.xiloe.mhack.Modules.Mods.Movement;

import me.deftware.client.framework.event.events.EventKeyAction;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.network.packets.ICPacketPlayer;

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
        ICPacketPlayer packet = (ICPacketPlayer) event.getIPacket();
        packet.setOnGround(true); // C03PacketPlayer | field_149474_g
    }

    @Override
    public void onKeyAction(EventKeyAction event) {

    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
}
