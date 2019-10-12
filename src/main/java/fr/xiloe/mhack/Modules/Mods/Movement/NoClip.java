package fr.xiloe.mhack.Modules.Mods.Movement;

import fr.xiloe.mhack.Modules.Mod;
import me.deftware.client.framework.event.events.EventKeyAction;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.wrappers.IChat;
import me.deftware.client.framework.wrappers.entity.IEntityPlayer;

import java.awt.event.KeyEvent;

public class NoClip extends Mod {

    public NoClip() {
        super("NoClip", "Clip in blocks (need to be stuck in a door)", KeyEvent.VK_V);
    }

    @Override
    public void onUpdate(EventUpdate event) {
        IEntityPlayer.setNoClip(true);
        IEntityPlayer.setFalldistance(0);
        IEntityPlayer.setOnGround(false);

        IEntityPlayer.setFlying(false);
        IEntityPlayer.setMotionX(0);
        IEntityPlayer.setMotionY(0);
        IEntityPlayer.setMotionZ(0);
    }

    @Override
    public void onPacketSend(EventPacketSend event) {

    }

    // TODO: Fix it
    @Override
    public void onKeyAction(EventKeyAction event) {
        float speed = 0.2f;

        if(event.getKeyCode() == KeyEvent.VK_SPACE) {
            IEntityPlayer.setMotionY(IEntityPlayer.getMotionY() + speed);
            IChat.sendClientMessage("Y+0.2f");
        }

        if(event.getKeyCode() == KeyEvent.KEY_LOCATION_LEFT + KeyEvent.VK_SHIFT) {
            IEntityPlayer.setMotionY(IEntityPlayer.getMotionY() - speed);
            IChat.sendClientMessage("Y-0.2f");
        }
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {
        IEntityPlayer.setNoClip(false);
    }
}
