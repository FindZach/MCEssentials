package com.findzach.mcessentials.feature.impl.spawn.cmd;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.PlayerCommand;
import com.findzach.mcessentials.feature.FeatureType;
import com.findzach.mcessentials.feature.impl.spawn.Spawn;
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
