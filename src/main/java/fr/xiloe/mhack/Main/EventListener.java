package fr.xiloe.mhack.Main;

import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventKeyAction;
import me.deftware.client.framework.event.events.EventUpdate;

public class EventListener extends me.deftware.client.framework.event.EventListener {

    @EventHandler(eventType = EventUpdate.class)
    public EventUpdate onUpdate(EventUpdate event) {
        return event;
    }

    @EventHandler(eventType = EventKeyAction.class)
    public EventKeyAction onUpdate(EventKeyAction event) {
        return event;
    }

}
