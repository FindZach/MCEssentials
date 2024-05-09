package com.findzach.mcessentials.content.command.impl.feature;

import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.command.SubCommand;
import com.findzach.mcessentials.content.util.Messager;
import org.bukkit.command.CommandSender;

/**
 * @author: Zach Smith
 * @date: 3/30/2024
 * @time: 11:46 PM
 */
@CommandInfo(name = "feature config <type>", permission = "essentials.feature.config", description = "Feature Configurations", commandType = CommandType.SUB_COMMAND)
public class ConfigCommand implements SubCommand {

    @Override
    public void execute(CommandSender sender, String subCommand, String[] args) {
        if (args.length > 0) {
            Messager.send(sender, "&aConfig for: " + args[0]);
        }
    }
}
