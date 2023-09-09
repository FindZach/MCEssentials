package com.findzach.mcessentials.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/9/2023
 */
public interface PlayerSubCommand extends SubCommand {
    @Override
    default void execute(CommandSender sender, String subCommand, String[] args) {
        execute((Player) sender, subCommand, args);
    }

    void execute(Player player, String subCommand, String[] args);
}
