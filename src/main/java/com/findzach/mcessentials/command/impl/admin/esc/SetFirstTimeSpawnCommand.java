package com.findzach.mcessentials.command.impl.admin.esc;

import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.PlayerSubCommand;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 *
 * This will set the spawn that users will join when they join for the first time
 */
@CommandInfo(name = "mce setfirstspawn", permission = "essentials.admin.setfirstspawn", description = "Basic set join spawn Command", commandType = CommandType.SUB_COMMAND)
public class SetFirstTimeSpawnCommand implements PlayerSubCommand {
    @Override
    public void execute(Player player, String subCommand, String[] args) {

    }

}
