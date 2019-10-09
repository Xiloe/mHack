package fr.xiloe.mhack.Modules;

import fr.xiloe.mhack.Modules.Mods.Movement.*;
import me.deftware.client.framework.event.events.*;
import me.deftware.client.framework.wrappers.IChat;

import java.util.HashMap;

public class ModManager {

    private HashMap<ModType, Mod> modlist = new HashMap<ModType, Mod>();
    public boolean done = false;

    public void initialize() {
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

    public void onKeyAction(EventKeyAction event) {
        for (Mod m : modlist.values()) {
            if (event != null) {
                if (m.getKeybind() == event.getKeyCode()) {
                    m.toggle();
                }
            }
        }
    }

}
