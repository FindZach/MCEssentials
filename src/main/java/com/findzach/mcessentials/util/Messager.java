package com.findzach.mcessentials.util;

import com.findzach.mcessentials.MCEssentials;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.List;

/**
 * A utility class to manage and streamline the process of sending messages
 * to players and command senders.
 * This class is also integrated with the PlaceholderAPI to replace placeholders
 * with their corresponding values.
 *
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class Messager {

    /**
     * Send a list of messages to a player.
     *
     * @param player   The target player.
     * @param messages The list of messages to send.
     */
    public static void send(Player player, List<String> messages) {
        for (String message : messages) {
            send(player, message);
        }
    }

    /**
     * Send a message to a player.
     * If PlaceholderAPI is enabled, it will replace any placeholders in the message.
     *
     * @param player The target player.
     * @param msg    The message to send.
     */
    public static void send(Player player, String msg) {
        if (MCEssentials.getInstance().isPlaceHolderAPILive()) {
            msg = PlaceholderAPI.setPlaceholders(player, msg);
        }
        send((CommandSender) player, msg);
    }

    /**
     * Send a message to a command sender (could be console or a command block)
     * with a prefixed message.
     *
     * @param sender The CommandSender.
     * @param msg    The message to send.
     */
    public static void send(CommandSender sender, String msg) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MCEssentials.getInstance().getMessage("message_prefix") + msg));
    }

    /**
     * Send a list of messages to a command sender.
     *
     * @param sender   The CommandSender.
     * @param messages The list of messages to send.
     */
    public static void send(CommandSender sender, List<String> messages) {
        for (String s: messages) {
            send(sender, s);
        }
    }
}
