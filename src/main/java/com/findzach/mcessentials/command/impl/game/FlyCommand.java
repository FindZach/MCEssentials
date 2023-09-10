package com.findzach.mcessentials.command.impl.game;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.PlayerCommand;
import com.findzach.mcessentials.config.ConfigKey;
import com.findzach.mcessentials.util.Messager;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
@CommandInfo(name = "fly", permission = "essentials.fly", description = "Toggles fly for user", commandType = CommandType.COMMAND)
public class FlyCommand implements PlayerCommand {

    @Override
    public void execute(Player player, String[] args) {
        boolean opposite = !player.isFlying();

        player.setAllowFlight(opposite);
        Messager.send(player, MCEssentials.getInstance().getMessages(ConfigKey.FLY_SELF.getKey()));
    }
}
