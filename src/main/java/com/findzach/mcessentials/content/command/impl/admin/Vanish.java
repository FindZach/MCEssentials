package com.findzach.mcessentials.content.command.impl.admin;

import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.command.PlayerCommand;
import com.findzach.mcessentials.content.feature.impl.vanish.VanishManager;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
@CommandInfo(name = "vanish", permission = "essentials.mod.vanish", description = "Toggles Vanish for user", commandType = CommandType.COMMAND)
public class Vanish implements PlayerCommand {
    public static VanishManager vanishManager = new VanishManager();
    @Override
    public void execute(Player player, String[] args) {
        if (vanishManager.isVanished(player)) {
            vanishManager.unvanish(player);
            player.sendMessage("You are now visible.");
        } else {
            vanishManager.vanish(player);
            player.sendMessage("You are now vanished.");
        }
    }
}
