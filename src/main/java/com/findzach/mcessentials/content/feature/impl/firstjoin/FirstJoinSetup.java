package com.findzach.mcessentials.content.feature.impl.firstjoin;

import com.findzach.mcessentials.content.feature.Feature;
import com.findzach.mcessentials.content.feature.FeatureType;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
public class FirstJoinSetup extends Feature {
    @Override
    protected void setConfigDefaults() {
        getFeatureConfig().addDefault("firstjoin.inventory", new String[] {
                "STONE_SWORD",
                "DIAMOND_HELMET"
        });
    }

    @Override
    public FeatureType getFeatureType() {
        return FeatureType.FIRST_JOIN;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event) {
        String firstJoinText = getFeatureConfig().getString("firstjoin.message");
        boolean sendJoinMsg = getFeatureConfig().getBoolean("welcome.message-enabled");

        /*
         * We parse the placeholders using "setPlaceholders"
         * This would turn %vault_rank% into the name of the Group, that the
         * joining player has.
         */
        firstJoinText = PlaceholderAPI.setPlaceholders(event.getPlayer(), firstJoinText);



        if (!event.getPlayer().hasPlayedBefore()) {
            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', firstJoinText));
        } else {
            if (sendJoinMsg) {
                String userJoinMessage = getFeatureConfig().getString("welcome.message");

                event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(event.getPlayer(), userJoinMessage)));
            }
        }
    }

}
