package fr.xiloe.mhack.Commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import fr.xiloe.mhack.Main.Main;
import fr.xiloe.mhack.Modules.Mod;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.CommandResult;
import me.deftware.client.framework.command.EMCModCommand;
import me.deftware.client.framework.wrappers.IChat;

import java.awt.event.KeyEvent;

public class KeybindManager extends EMCModCommand {

    Mod module;
    KeyEvent keybind;

    // TODO: Refactor the save system + eventually make this working

    @Override
    public CommandBuilder getCommandBuilder() {
        return new CommandBuilder().set((LiteralArgumentBuilder) LiteralArgumentBuilder.literal("bind")
                .then(
                        RequiredArgumentBuilder.argument("module", StringArgumentType.string())
                                .executes(c -> {
                                    CommandResult r = new CommandResult(c);
                                    for(Mod m : Main.getModmanager().getModlist().values()) {
                                        if(m.getName().equalsIgnoreCase(r.getString("module"))) {
                                            module = m;
                                        }
                                    }
                                    return 1;
                                })
                                .then(
                                    RequiredArgumentBuilder.argument("keybind", StringArgumentType.string())
                                            .executes(c -> {
                                                CommandResult r = new CommandResult(c);
                                                IChat.sendClientMessage("Set " + module.getName() + " keybind to " + r.getString("keybind"), Main.PREFIX);
                                                return 1;
                                            })
                                )
                )
        );
    }
}
