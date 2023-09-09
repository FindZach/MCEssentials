package com.findzach.mcessentials.command.impl.time;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.Command;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.util.TimeUtility;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
@CommandInfo(name = "day", permission = "essentials.day", description = "Sets the time to day", commandType = CommandType.COMMAND)
public class DayCommand implements Command {
    @Override
    public void execute(CommandSender sender, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(TimeUtility.setTime(TimeUtility.Time.DAY, player.getWorld()));
        } else {
            if (args.length > 0) {
                String world = args[0];
                World selectedWorld = MCEssentials.getInstance().getServer().getWorld(world);
                if (selectedWorld != null) {
                    sender.sendMessage(TimeUtility.setTime(TimeUtility.Time.DAY, selectedWorld));
                } else {
                    sender.sendMessage(ChatColor.RED + "INVALID World " + args[0]);
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Please input world name! Ex: /day world");
            }
        }
    }
}
