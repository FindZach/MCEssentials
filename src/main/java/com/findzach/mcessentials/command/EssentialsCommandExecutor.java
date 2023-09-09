package com.findzach.mcessentials.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Optional;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class EssentialsCommandExecutor implements org.bukkit.command.CommandExecutor {
    private CommandManager registry;

    public EssentialsCommandExecutor(CommandManager registry) {
        this.registry = registry;
    }

    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param cmd Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        Optional<Command> command = registry.getCommand(cmd.getName());
        if (command.isPresent()) {
            if (sender.hasPermission(command.get().getPermission())) {
                if (command.get() instanceof PlayerCommand) {
                    Player player = (Player) sender;
                    command.get().execute(player, args);
                } else {
                    System.out.println("This is not a PlayerCommand!");
                    command.get().execute(sender, args);
                }
                return true;
            } else {
                sender.sendMessage("You do not have permission to use this command.");
                return false;
            }
        } else {
            System.out.println("Command is not present! " + cmd.getName());
        }
        return false;
    }

}
