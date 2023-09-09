package com.findzach.mcessentials.command.impl.util;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.SubCommand;
import org.bukkit.command.CommandSender;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */

@CommandInfo(name = "mce reload", permission = "essentials.reload", description = "Essentials Reload", commandType = CommandType.SUB_COMMAND)
public class EssentialsReloadCommand implements SubCommand {
    @Override
    public void handleSubCommand(CommandSender sender, String subCommand, String[] args) {
        MCEssentials.getInstance().reloadPluginConfig();
    }
}
