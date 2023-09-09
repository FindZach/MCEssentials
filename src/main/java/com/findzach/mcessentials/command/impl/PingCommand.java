package com.findzach.mcessentials.command.impl;

import com.findzach.mcessentials.command.Command;
import com.findzach.mcessentials.command.CommandInfo;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
@CommandInfo(name = "ping", permission = "essentials.ping", description = "Sends a pong response")
public class PingCommand implements Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(ChatColor.RED + "pong!");
    }
}
