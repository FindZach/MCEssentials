package com.findzach.mcessentials.command.impl.feature;

import com.findzach.mcessentials.command.Command;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.util.Messager;
import org.bukkit.command.CommandSender;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */

@CommandInfo(name = "feature", permission = "essentials.feature", description = "Basic Feature Commands", commandType = CommandType.COMMAND)
public class FeatureCommand implements Command {
    @Override
    public void execute(CommandSender sender, String[] args) {
        Messager.send(sender, "&eWe're back baby!");
    }
}
