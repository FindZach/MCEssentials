package com.findzach.mcessentials.content.command.impl;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.content.command.Command;
import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.util.Messager;
import org.bukkit.command.CommandSender;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
@CommandInfo(name = "ping", permission = "essentials.ping", description = "Sends a pong response", commandType = CommandType.COMMAND)
public class PingCommand implements Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        Messager.send(sender, MCEssentials.getInstance().getMessages("basic.ping"));
    }
}
