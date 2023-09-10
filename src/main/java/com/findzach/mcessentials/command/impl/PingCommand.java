package com.findzach.mcessentials.command.impl;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.Command;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.util.Messager;
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
