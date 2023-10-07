package com.enormouz.mythicprotector.commands;

import com.enormouz.mythicprotector.MythicProtector;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.IClientCommand;

import java.util.ArrayList;
import java.util.List;

public class MythicProtectorCommand extends CommandBase implements IClientCommand {
    private final List<String> aliases;

    public MythicProtectorCommand() {
        aliases = new ArrayList<String>();
        aliases.add("mp");
    }

    @Override
    public boolean allowUsageWithoutPrefix(ICommandSender sender, String s) {
        return false;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] params) throws CommandException {
        MythicProtector.guiToDraw = MythicProtector.configFile.gui();
    }

    @Override
    public String getName() {
        return "mythicprotector";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "Opens the MythicProtector GUI";
    }

    @Override
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
