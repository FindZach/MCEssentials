package com.findzach.mcessentials.util;

import com.findzach.mcessentials.MCEssentials;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class Messager {

    public static void send(Player player, String msg) {
        if (MCEssentials.getInstance().isPlaceHolderAPILive()) {
            msg = PlaceholderAPI.setPlaceholders(player, msg);
        }
        send((CommandSender) player, msg);
    }

    public static void send(CommandSender sender, String msg) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MCEssentials.getInstance().getMessage("message_prefix") + msg));
    }
}
