package fr.xiloe.mhack.Commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.EMCModCommand;

public class ClientCommands extends EMCModCommand {


    public static boolean coordinates = false;
    public static boolean gui = true;

    @Override
    public CommandBuilder getCommandBuilder() {
        return new CommandBuilder().set(LiteralArgumentBuilder.literal("toggle")
                .then(
                        LiteralArgumentBuilder.literal("coordinates")
                                .executes(c -> {
                                    coordinates = !coordinates;
                                    return 1;
                                })
                )
                .then(
                        LiteralArgumentBuilder.literal("gui")
                                .executes(c -> {
                                    gui = !gui;
                                    return 1;
                                })
                )
        );
    }

}
