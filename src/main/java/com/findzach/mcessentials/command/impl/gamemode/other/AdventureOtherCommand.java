package com.findzach.mcessentials.command.impl.gamemode.other;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.SubCommand;
import com.findzach.mcessentials.util.Messager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */

@CommandInfo(name = "gma <player>", permission = "essentials.gma.other", description = "Toggles fly for user", commandType = CommandType.SUB_COMMAND)
public class AdventureOtherCommand implements SubCommand {
    @Override
    public void execute(CommandSender sender, String subCommand, String[] args) {
        Player selectedPlayer = Bukkit.getPlayer(args[0]);

        if (selectedPlayer == null) {
            Messager.send(sender, MCEssentials.getInstance().getMessage("invalid-player").replaceAll("%invalidName%", args[0]));
            return;
        }

        selectedPlayer.setAllowFlight(!selectedPlayer.getAllowFlight());
        Messager.send(sender, MCEssentials.getInstance().getMessage("fly-other").replace("%selectedName%", selectedPlayer.getDisplayName()));

    }
}
