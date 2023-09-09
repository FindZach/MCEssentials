package com.findzach.mcessentials.command.impl.util;

import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.PlayerCommand;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
@CommandInfo(name = "fly", permission = "essentials.fly", description = "Toggles fly for user")
public class FlyCommand implements PlayerCommand {
    @Override
    public void execute(Player player, String[] args) {
       player.setFlying(!player.isFlying());
    }
}
