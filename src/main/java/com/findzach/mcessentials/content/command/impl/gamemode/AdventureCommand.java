package com.findzach.mcessentials.content.command.impl.gamemode;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.command.PlayerCommand;
import com.findzach.mcessentials.content.util.Messager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
@CommandInfo(name = "gma", permission = "essentials.gma", description = "Gamemode Adventure Switch", commandType = CommandType.COMMAND)
public class AdventureCommand implements PlayerCommand {

    @Override
    public void execute(Player sender, String[] args) {
        sender.setGameMode(GameMode.ADVENTURE);
        Messager.send(sender, MCEssentials.getInstance().getMessages("gma.self"));
    }
}