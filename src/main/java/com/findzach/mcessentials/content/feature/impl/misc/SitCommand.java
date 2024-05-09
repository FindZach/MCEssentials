package com.findzach.mcessentials.content.feature.impl.misc;

import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.command.PlayerSubCommand;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
@CommandInfo(name = "mce sit config", permission = "essentials.sit.config", description = "Adds block to the sit list", commandType = CommandType.SUB_COMMAND)
public class SitCommand implements PlayerSubCommand {

    @Override
    public void execute(Player player, String subCommand, String[] args) {
        player.sendMessage("Hello World");
    }
}
