package com.findzach.mcessentials.content.command.impl.essential;

import com.findzach.mcessentials.content.command.Command;
import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.util.Messager;
import org.bukkit.command.CommandSender;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */

@CommandInfo(name = "mce", permission = "essentials.essential", description = "Sends a pong response", commandType = CommandType.COMMAND)
public class EssentialCommand implements Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        Messager.send(sender, "&aEssentials Version: v1");
    }
}
