package com.findzach.mcessentials.command.impl.gamemode;

import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.PlayerCommand;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
@CommandInfo(name = "gmc", permission = "essentials.gmc", description = "Gamemode Creative Switch")
public class CreativeCommand implements PlayerCommand {

    @Override
    public void execute(Player sender, String[] args) {
        sender.sendMessage("Your game mode is now creative");
    }
}