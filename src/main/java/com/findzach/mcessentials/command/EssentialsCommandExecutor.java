package com.findzach.mcessentials.command;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Optional;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class EssentialsCommandExecutor implements CommandExecutor {
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
        String fullCommand = args.length > 0 ? cmd.getName() + " " + String.join(" ", args) : cmd.getName();

        if (args.length > 0) {
            Optional<SubCommand> subCommand = registry.getSubCommand(fullCommand);
            if (subCommand.isPresent()) {
                return handleSubCommandExecution(subCommand.get(), sender, fullCommand, args);
            }
        } else {
            Optional<Command> command = registry.getCommand(cmd.getName());
            if (command.isPresent()) {
                return handleCommandExecution(command.get(), sender, args);
            }
        }
        return false;
    }

    private boolean handleSubCommandExecution(SubCommand subCmd, CommandSender sender, String fullCommand, String[] args) {
        if (!sender.hasPermission(subCmd.getPermission())) {
            sender.sendMessage("You do not have permission to use this command.");
            return false;
        }

        if (subCmd instanceof PlayerSubCommand && !(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[MCEssentials] Command: '" + fullCommand.split(" ")[0] + "' is a Player only command!");
            return false;
        }

        if (sender instanceof Player) {
            subCmd.execute((Player) sender, fullCommand, args);
        } else {
            subCmd.execute(sender, fullCommand, args);
        }

        return true;
    }

    private boolean handleCommandExecution(Command cmd, CommandSender sender, String[] args) {
        if (!sender.hasPermission(cmd.getPermission())) {
            sender.sendMessage("You do not have permission to use this command.");
            return false;
        }

        if (cmd instanceof PlayerCommand && !(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[MCEssentials] Command: '" + cmd.getName() + "' is a Player only command!");
            return false;
        }

        if (sender instanceof Player) {
            cmd.execute((Player) sender, args);
        } else {
            cmd.execute(sender, args);
        }

        return true;
    }

}
