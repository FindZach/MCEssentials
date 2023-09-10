package com.findzach.mcessentials.command.impl.gamemode.other;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.SubCommand;
import com.findzach.mcessentials.config.ConfigKey;
import com.findzach.mcessentials.util.Messager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
@CommandInfo(name = "gmspec <player>", permission = "essentials.gmspec.other", description = "Applies Spectator mode to the selected player", commandType = CommandType.SUB_COMMAND)
public class SetSpectatorCommand implements SubCommand {
    @Override
    public void execute(CommandSender sender, String subCommand, String[] args) {
        Player selectedPlayer = Bukkit.getPlayer(args[0]);

        // Check if the player is valid.
        if (selectedPlayer == null) {
            List<String> messages = MCEssentials.getInstance().getMessages(ConfigKey.ERROR_MSG_INVALID_USER.getKey());
            for (String error: messages) {
                error.replaceAll("%invalidPlayer%", args[0]);
            }
            Messager.send(sender, messages);
            return;
        }

        selectedPlayer.setGameMode(GameMode.SPECTATOR);
        List<String> gmcOther = MCEssentials.getInstance().getMessages(ConfigKey.GMSPEC_OTHER.getKey());
        List<String> updated = new ArrayList<>();

        for (String gmc: gmcOther) {
            updated.add(gmc.replaceAll("%selectedPlayer%", selectedPlayer.getDisplayName()));
        }

        Messager.send(sender, updated);
    }
}
