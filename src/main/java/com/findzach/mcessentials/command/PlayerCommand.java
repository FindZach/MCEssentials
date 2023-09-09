package com.findzach.mcessentials.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/9/2023
 */
public interface PlayerCommand extends Command {

    @Override
    default void execute(CommandSender sender, String[] args) {
        execute((Player) sender, args);
    }

    void execute(Player sender, String[] args);
}
