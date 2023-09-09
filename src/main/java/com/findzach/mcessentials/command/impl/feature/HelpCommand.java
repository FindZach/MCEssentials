package com.findzach.mcessentials.command.impl.feature;

import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.SubCommand;
import com.findzach.mcessentials.util.Messager;
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
