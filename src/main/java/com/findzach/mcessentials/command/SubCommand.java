package com.findzach.mcessentials.command;

import org.bukkit.command.CommandSender;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/9/2023
 */
public interface SubCommand {
    void handleSubCommand(CommandSender sender, String subCommand, String[] args);
}
