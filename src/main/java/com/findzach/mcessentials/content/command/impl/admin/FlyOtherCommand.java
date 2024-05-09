package com.findzach.mcessentials.content.command.impl.admin;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.command.SubCommand;
import com.findzach.mcessentials.io.config.ConfigKey;
import com.findzach.mcessentials.content.util.Messager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 *
 * Command that toggles the fly for the selected player
 */
@CommandInfo(name = "fly <player>", permission = "essentials.mod.fly", description = "Toggles fly for user", commandType = CommandType.SUB_COMMAND)
public class FlyOtherCommand implements SubCommand {

    @Override
    public void execute(CommandSender sender, String subCommand, String[] args) {
        Player selectedPlayer = Bukkit.getPlayer(args[0]);

        if (selectedPlayer == null) {
            Messager.send(sender, MCEssentials.getInstance().getMessage("invalid-player").replaceAll("%invalidName%", args[0]));
            return;
        }

        selectedPlayer.setAllowFlight(!selectedPlayer.getAllowFlight());
        List<String> configMessages = MCEssentials.getInstance().getMessages("fly.other");
        List<String> updatedMessages = configMessages.stream()
                .map(s -> s.replace("%selectedPlayer%", selectedPlayer.getDisplayName()))
                .collect(Collectors.toList());

        Messager.send(selectedPlayer, MCEssentials.getInstance().getMessages(ConfigKey.FLY_SELF.getKey()));
        Messager.send(sender, updatedMessages);
    }

}
