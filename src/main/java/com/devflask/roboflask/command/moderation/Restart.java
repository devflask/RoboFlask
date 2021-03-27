package com.devflask.roboflask.command.moderation;

import com.devflask.roboflask.command.Command;
import com.devflask.roboflask.command.CommandInformation;
import net.dv8tion.jda.api.Permission;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class Restart implements Command {
    @Override
    public @NotNull String getName() {
        return "restart";
    }

    @Override
    public @NotNull Set<String> getAlias() {
        return new HashSet<>();
    }

    @Override
    public @NotNull String getHelp() {
        return "Restarts the bot";
    }

    @Override
    public void execute(CommandInformation info){
        System.exit(0);
    }

    @Override
    public @NotNull Set<Permission> getRequiredPermissions() {
        Set<Permission> permissions = new HashSet<>();
        permissions.add(Permission.ADMINISTRATOR);
        return permissions;
    }
}
