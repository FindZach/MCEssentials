package com.findzach.mcessentials.command.impl;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.MCEssentialsConstant;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.PlayerCommand;
import com.findzach.mcessentials.util.Messager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */

@CommandInfo(name = "spawn", permission = "essentials.spawn", description = "Teleports user to the servers Spawn", commandType = CommandType.COMMAND)
public class SpawnCommand implements PlayerCommand {
    @Override
    public void execute(Player player, String[] args) {
        if (MCEssentials.getInstance().getConfig().getBoolean("Spawn-Enabled")) {
            MCEssentials mcEssentials = MCEssentials.getInstance();

            Map<String, Object> spawnMap = (Map<String, Object>) mcEssentials.getConfig().get("spawn");
            if (spawnMap != null) {

                int delay = mcEssentials.getConfig().getInt("Teleport-Delay");

                Messager.send(player, mcEssentials.getMessage("spawn").replaceAll("%delay_in_seconds%", String.valueOf(delay)));


                Bukkit.getScheduler().runTaskLater(mcEssentials, () -> {
                    player.teleport(MCEssentialsConstant.getSpawn());

                    Messager.send(player, mcEssentials.getMessage("spawn-complete"));

                }, delay * 20);
            }
        }
    }
}
