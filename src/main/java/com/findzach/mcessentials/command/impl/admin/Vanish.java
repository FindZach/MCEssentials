package com.findzach.mcessentials.command.impl.admin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.PlayerCommand;
import com.findzach.mcessentials.feature.impl.vanish.VanishManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collections;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
@CommandInfo(name = "vanish", permission = "essentials.mod.vanish", description = "Toggles Vanish for user", commandType = CommandType.SUB_COMMAND)
public class Vanish implements PlayerCommand {
    private VanishManager vanishManager = MCEssentials.getInstance().getVanishManager();
    @Override
    public void execute(Player player, String[] args) {
        if (vanishManager.isVanished(player)) {
            vanishManager.unvanish(player);
            player.sendMessage("You are now visible.");
        } else {
            vanishManager.vanish(player);
            player.sendMessage("You are now vanished.");
        }
    }
}
