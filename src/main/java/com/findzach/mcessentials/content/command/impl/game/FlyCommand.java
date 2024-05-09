package com.findzach.mcessentials.content.command.impl.game;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.command.PlayerCommand;
import com.findzach.mcessentials.io.config.ConfigKey;
import com.findzach.mcessentials.content.util.Messager;
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
