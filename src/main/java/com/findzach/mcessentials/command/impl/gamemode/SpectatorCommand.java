package com.findzach.mcessentials.command.impl.gamemode;

import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.PlayerCommand;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
@CommandInfo(name = "gmspec", permission = "essentials.gmspec", description = "Gamemode Spectator Switch")
public class SpectatorCommand implements PlayerCommand {
    @Override
    public void execute(Player sender, String[] args) {
        sender.sendMessage("Your game mode is now creative");
    }
}