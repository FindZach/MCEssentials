package com.findzach.mcessentials.feature.impl.vanish;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
public class VanishManager {
    private final Set<UUID> vanishedPlayers = new HashSet<>();

    public void vanish(Player player) {
        vanishedPlayers.add(player.getUniqueId());
    }

    public void unvanish(Player player) {
        vanishedPlayers.remove(player.getUniqueId());
    }

    public boolean isVanished(Player player) {
        return vanishedPlayers.contains(player.getUniqueId());
    }
}
