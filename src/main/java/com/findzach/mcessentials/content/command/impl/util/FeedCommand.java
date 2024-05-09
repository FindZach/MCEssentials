package com.findzach.mcessentials.content.command.impl.util;

import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.command.PlayerCommand;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */

@CommandInfo(name = "feed", permission = "essentials.feed", description = "Restores your food bar", commandType = CommandType.COMMAND)
public class FeedCommand implements PlayerCommand {
    @Override
    public void execute(Player player, String[] args) {

        player.setFoodLevel(20);

    }
}
