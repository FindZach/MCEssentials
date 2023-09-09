package com.findzach.mcessentials.command.impl.gamemode;

import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.PlayerCommand;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
@CommandInfo(name = "gma", permission = "essentials.gma", description = "Gamemode Adventure Switch")
public class AdventureCommand implements PlayerCommand {

    @Override
    public void execute(Player sender, String[] args) {
        sender.setGameMode(GameMode.ADVENTURE);
        sender.sendMessage("Your game mode is now Adventure");
    }
}