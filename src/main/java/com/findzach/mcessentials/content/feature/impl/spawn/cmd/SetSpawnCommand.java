package com.findzach.mcessentials.content.feature.impl.spawn.cmd;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.command.PlayerCommand;
import com.findzach.mcessentials.content.feature.FeatureType;
import com.findzach.mcessentials.content.feature.impl.spawn.Spawn;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
@CommandInfo(name = "setspawn", permission = "essentials.setspawn", description = "Sets the servers Spawn", commandType = CommandType.COMMAND)
public class SetSpawnCommand implements PlayerCommand {

    @Override
    public void execute(Player player, String[] args) {
        Spawn spawnFeature = (Spawn)MCEssentials.getInstance().getFeatureManager().getFeature(FeatureType.SPAWN);
        spawnFeature.updateSpawn(player.getLocation());
        player.sendMessage("Setting spawn...");
    }
}
