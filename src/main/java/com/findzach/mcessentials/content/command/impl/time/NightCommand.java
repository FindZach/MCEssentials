package com.findzach.mcessentials.content.command.impl.time;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.content.command.Command;
import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.util.Messager;
import com.findzach.mcessentials.content.util.TimeUtility;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
@CommandInfo(name = "night", permission = "essentials.night", description = "Sets the time to night", commandType = CommandType.COMMAND)
public class NightCommand implements Command {
    @Override
    public void execute(CommandSender sender, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Messager.send(player, TimeUtility.setTime(TimeUtility.Time.NIGHT, player.getWorld()));
        } else {
            if (args.length > 0) {
                String world = args[0];
                World selectedWorld = MCEssentials.getInstance().getServer().getWorld(world);
                if (selectedWorld != null) {
                    Messager.send(sender, TimeUtility.setTime(TimeUtility.Time.NIGHT, selectedWorld));
                } else {
                    sender.sendMessage(ChatColor.RED + "INVALID World " + args[0]);
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Please input world name! Ex: /day world");
            }
        }
    }
}
