package com.findzach.mcessentials.command.impl.util;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandManager;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.PlayerCommand;
import com.findzach.mcessentials.util.Messager;
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
        Messager.send(player, MCEssentials.getInstance().getMessage("heal"));
    }
}
