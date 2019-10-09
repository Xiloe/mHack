package fr.xiloe.mhack.Commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.EMCModCommand;
import me.deftware.client.framework.wrappers.IChat;

public class TestCommands extends EMCModCommand {


    @Override
    public CommandBuilder getCommandBuilder() {
        return new CommandBuilder().set(LiteralArgumentBuilder.literal("debug")
                .then(
                        LiteralArgumentBuilder.literal("modlist")
                            .executes(c -> {
                                IChat.sendClientMessage("status: ");
                                return 1;
                            })
                )
        );
    }
}
