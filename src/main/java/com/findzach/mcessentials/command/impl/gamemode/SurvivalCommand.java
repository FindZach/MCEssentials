package com.findzach.mcessentials.command.impl.gamemode;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.PlayerCommand;
import com.findzach.mcessentials.util.Messager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
@CommandInfo(name = "gms", permission = "essentials.gms", description = "Gamemode Survival Switch", commandType = CommandType.COMMAND)
public class SurvivalCommand implements PlayerCommand {

    @Override
    public void execute(Player sender, String[] args) {
        sender.setGameMode(GameMode.SURVIVAL);
        Messager.send(sender, MCEssentials.getInstance().getMessages("gms.self"));
    }
}