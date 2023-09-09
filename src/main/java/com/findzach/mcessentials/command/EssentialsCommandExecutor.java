package com.findzach.mcessentials.command;

import org.bukkit.ChatColor;
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

        Optional<Command> subCommand = registry.getSubCommand(cmd.getName());

        if (args.length > 0) {
            if (subCommand.isPresent()) {
                if (sender.hasPermission(command.get().getPermission())) {
                    if (subCommand.get() instanceof PlayerSubCommand) {
                        if (sender instanceof Player) {
                            Player player = (Player) sender;
                            subCommand.get().execute(player, args);
                        } else {
                            sender.sendMessage(ChatColor.RED + "[MCEssentials] Command: '" + cmd.getName() + "' is a Player only command!");
                        }
                    } else {
                        subCommand.get().execute(sender, args);
                    }
                    return true;
                } else {
                    sender.sendMessage("You do not have permission to use this command.");
                    return false;
                }
            } else {
                System.out.println("SubCommand is not present! " + cmd.getName());
            }
        }

        if (command.isPresent()) {
            if (sender.hasPermission(command.get().getPermission())) {
                if (command.get() instanceof PlayerCommand) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        command.get().execute(player, args);
                    } else {
                        sender.sendMessage(ChatColor.RED + "[MCEssentials] Command: '" + cmd.getName() + "' is a Player only command!");
                    }
                } else {
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
