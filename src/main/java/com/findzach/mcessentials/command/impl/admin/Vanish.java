package com.findzach.mcessentials.command.impl.admin;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.PlayerCommand;
import com.findzach.mcessentials.feature.impl.vanish.VanishManager;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
@CommandInfo(name = "vanish", permission = "essentials.mod.vanish", description = "Toggles Vanish for user", commandType = CommandType.SUB_COMMAND)
public class Vanish implements PlayerCommand {
    private VanishManager vanishManager = MCEssentials.getInstance().getVanishManager();
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
