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
 * Handles the sub-command to apply creative mode to a selected player.
 * <p>
 * Command Info:
 * - Name: gmc &lt;player&gt;
 * - Permission: essentials.gmc.other
 * - Description: Applies creative mode to the selected player
 * - Type: SUB_COMMAND
 * </p>
 *
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
@CommandInfo(name = "gmc <player>", permission = "essentials.gmc.other", description = "Applies creative mode to the selected player", commandType = CommandType.SUB_COMMAND)
public class CreativeOtherCommand implements SubCommand {

    /**
     * Executes the sub-command.
     *
     * @param sender     The command's sender.
     * @param subCommand The sub-command invoked.
     * @param args       Additional arguments passed to the sub-command.
     */
    @Override
    public void execute(CommandSender sender, String subCommand, String[] args) {
        Player selectedPlayer = Bukkit.getPlayer(args[0]);

        // Check if the player is valid.
        if (selectedPlayer == null) {
            List<String> messages = MCEssentials.getInstance().getMessages(ConfigKey.ERROR_MSG_INVALID_USER.getKey());
            List<String> updated = new ArrayList<>();
            for (String error: messages) {
                updated.add(error.replaceAll("%invalidPlayer%", args[0]));
            }
            Messager.send(sender, updated);
            return;
        }

        selectedPlayer.setGameMode(GameMode.CREATIVE);
        List<String> gmcOther = MCEssentials.getInstance().getMessages(ConfigKey.GMC_OTHER.getKey());
        List<String> updated = new ArrayList<>();

        for (String gmc: gmcOther) {
            updated.add(gmc.replaceAll("%selectedPlayer%", selectedPlayer.getDisplayName()));
        }

        Messager.send(sender, updated);
    }
}
