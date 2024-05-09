package com.findzach.mcessentials.content.command.impl.util;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.command.PlayerCommand;
import com.findzach.mcessentials.content.util.Messager;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */

@CommandInfo(name = "heal", permission = "essentials.heal", description = "Heals your health", commandType = CommandType.COMMAND)
public class HealCommand implements PlayerCommand {
    @Override
    public void execute(Player player, String[] args) {
        player.setHealth(player.getMaxHealth());
        Messager.send(player, MCEssentials.getInstance().getMessage("basic.heal"));
    }
}
