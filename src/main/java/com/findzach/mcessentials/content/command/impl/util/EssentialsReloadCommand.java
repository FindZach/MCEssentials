package com.findzach.mcessentials.content.command.impl.util;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.command.SubCommand;
import com.findzach.mcessentials.content.util.Messager;
import org.bukkit.command.CommandSender;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */

@CommandInfo(name = "mce reload", permission = "essentials.reload", description = "Essentials Reload", commandType = CommandType.SUB_COMMAND)
public class EssentialsReloadCommand implements SubCommand {

    @Override
    public void execute(CommandSender sender, String subCommand, String[] args) {
        MCEssentials.getInstance().reloadPluginConfig();
        Messager.send(sender, "&cReloaded MCEssentials Config!");
    }
}
