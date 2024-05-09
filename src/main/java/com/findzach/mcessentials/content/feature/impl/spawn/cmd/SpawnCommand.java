package com.findzach.mcessentials.content.feature.impl.spawn.cmd;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.command.PlayerCommand;
import com.findzach.mcessentials.content.feature.FeatureType;
import com.findzach.mcessentials.content.feature.impl.spawn.Spawn;
import com.findzach.mcessentials.content.util.Messager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
@CommandInfo(name = "spawn", permission = "essentials.spawn", description = "Teleports to the server spawn", commandType = CommandType.COMMAND)
public class SpawnCommand implements PlayerCommand {

    @Override
    public void execute(Player player, String[] args) {
        Spawn spawnFeature = (Spawn) MCEssentials.getInstance().getFeatureManager().getFeature(FeatureType.SPAWN);
        MCEssentials mcEssentials = MCEssentials.getInstance();

        if (spawnFeature.getSpawn() == null) {
            player.sendMessage("There is no Spawn point set, tell Administrator to type /setspawn");
            return;
        }

        int delay = spawnFeature.getFeatureConfig().getInt("spawn.spawn-delay");

        List<String> configMessages = mcEssentials.getMessages("spawn.begin-teleport");
        List<String> updatedMessages = configMessages.stream()
                .map(s -> s.replace("%delay_in_seconds%", String.valueOf(delay)))
                .collect(Collectors.toList());

        Messager.send(player,updatedMessages);

        Location requestLocation = player.getLocation().clone();

        Bukkit.getScheduler().runTaskLater(mcEssentials, () -> {
            boolean cancelOnMovement = spawnFeature.getFeatureConfig().getBoolean("spawn.cancel-on-movement");
            if (requestLocation.distance(player.getLocation()) <= 1 || !cancelOnMovement) {
                player.teleport(spawnFeature.getSpawn());
                Messager.send(player, mcEssentials.getMessages("spawn.complete-teleport"));
            } else {
                Messager.send(player, mcEssentials.getMessages("spawn.cancelled"));
            }
        }, delay * 20);
    }

}
