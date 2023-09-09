package com.findzach.mcessentials.command.impl.admin;

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
 * @since 9/9/2023
 *
 * Command that toggles the fly for the selected player
 */
@CommandInfo(name = "fly <player>", permission = "essentials.mod.fly", description = "Toggles fly for user", commandType = CommandType.SUB_COMMAND)
public class FlyCommand implements SubCommand {
    @Override
    public void execute(CommandSender sender, String subCommand, String[] args) {
        Player selectedPlayer = Bukkit.getPlayer(args[0]);
        if (selectedPlayer == null) {
            Messager.send(sender, MCEssentials.getInstance().getMessage("invalid-player").replaceAll("[InvalidName]", args[0]));
            return;
        }
        selectedPlayer.setAllowFlight(!selectedPlayer.getAllowFlight());
        Messager.send(sender, MCEssentials.getInstance().getMessage("fly-other").replaceAll("[selectedName]", selectedPlayer.getDisplayName()));
    }
}
