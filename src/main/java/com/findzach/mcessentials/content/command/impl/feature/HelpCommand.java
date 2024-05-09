package com.findzach.mcessentials.content.command.impl.feature;

import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.command.SubCommand;
import com.findzach.mcessentials.content.util.Messager;
import org.bukkit.command.CommandSender;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */

@CommandInfo(name = "feature help", permission = "essentials.feature", description = "Feature Help", commandType = CommandType.SUB_COMMAND)
public class HelpCommand implements SubCommand {
    @Override
    public void execute(CommandSender sender, String subCommand, String[] args) {
        Messager.send(sender, "&cSubcommand: " + subCommand);


    }
}
