package fr.xiloe.mhack.Modules;

import me.deftware.client.framework.event.events.EventUpdate;

public abstract class Mod {

    private String name;
    private String description;
    private int keybind;

    private boolean state;

    public Mod(String name, String description, int keybind) {
        this.name = name;
        this.description = description;
        this.keybind = keybind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKeybind() {
        return keybind;
    }

    public void setKeybind(int keybind) {
        this.keybind = keybind;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void toggle() {
        this.state = !state;
        // IChat.sendClientMessage(ChatColor.AQUA + this.getName() + ChatColor.GRAY +" is now " + (state ? ChatColor.GREEN + "enabled" + ChatColor.GRAY : ChatColor.RED + "disabled" + ChatColor.GRAY), Main.prefix);
        if (state) {
            this.onEnable();
        } else {
            this.onDisable();
        }
    }

    public abstract void onUpdate(EventUpdate event);

    public abstract void onEnable();

    public abstract void onDisable();

}
