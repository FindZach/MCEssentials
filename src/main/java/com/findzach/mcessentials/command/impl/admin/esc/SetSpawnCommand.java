package com.findzach.mcessentials.command.impl.admin.esc;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.PlayerSubCommand;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
@CommandInfo(name = "mce setspawn", permission = "essentials.admin.setspawn", description = "Basic SpawnSpawn Command", commandType = CommandType.SUB_COMMAND)
public class SetSpawnCommand implements PlayerSubCommand {

    @Override
    public void execute(Player player, String subCommand, String[] args) {
        Location currentSpot = player.getLocation();


        MCEssentials.getInstance().getConfig().set("Use-Essentials-For-Spawn", true);
        MCEssentials.getInstance().getConfig().set("spawn", currentSpot.serialize());
        MCEssentials.getInstance().saveConfig();

    }
}