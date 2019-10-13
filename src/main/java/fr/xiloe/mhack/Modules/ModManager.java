package fr.xiloe.mhack.Modules;

import fr.xiloe.mhack.Modules.Mods.Movement.Flight;
import fr.xiloe.mhack.Modules.Mods.Movement.NoClip;
import fr.xiloe.mhack.Modules.Mods.Movement.NoFall;
import fr.xiloe.mhack.Modules.Mods.Movement.Sprint;
import me.deftware.client.framework.event.events.EventDamage;
import me.deftware.client.framework.event.events.EventKeyAction;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.event.events.EventUpdate;

import java.util.HashMap;

public class ModManager {

    private HashMap<ModType, Mod> modlist = new HashMap<>();
    public boolean done = false;

    public void initialize() {
        modlist.put(ModType.SPRINT, new Sprint());
        modlist.put(ModType.NOFALL, new NoFall());
        modlist.put(ModType.NOCLIP, new NoClip());
        modlist.put(ModType.FLIGHT, new Flight());
        done = true;
    }

    public HashMap<ModType, Mod> getModlist() {
        return modlist;
    }

    public Mod getMod(String mod) {
        for(Mod m : modlist.values()) {
            if(m.getName().toLowerCase().equals(mod.toLowerCase())) {
                return m;
            }
        }

        return null;
    }

    public void onUpdate(EventUpdate event) {
        for (Mod m : modlist.values()) {
            if (m.isState()) {
                m.onUpdate(event);
            }
        }
    }

    public void onPacketSend(EventPacketSend event) {
        for (Mod m : modlist.values()) {
            if (m.isState()) {
                m.onPacketSend(event);
            }
        }
    }

    public void onKeyAction(EventKeyAction event) {
        for (Mod m : modlist.values()) {
            if (event != null) {
                if (m.getKeybind() == event.getKeyCode()) {
                    m.toggle();
                }
            }

            if (m.isState()) {
                m.onKeyAction(event);
            }
        }
    }

}
