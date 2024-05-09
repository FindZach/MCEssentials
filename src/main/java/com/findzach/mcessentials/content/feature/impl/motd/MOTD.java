package com.findzach.mcessentials.content.feature.impl.motd;

import com.findzach.mcessentials.io.config.ConfigKey;
import com.findzach.mcessentials.content.feature.Feature;
import com.findzach.mcessentials.content.feature.FeatureType;
import com.findzach.mcessentials.content.util.Utility;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
public class MOTD extends Feature {

    private static List<String> randomMOTDMessages = new ArrayList<>();

    private static boolean randomMOTD = false;

    @Override
    protected void setConfigDefaults() {}

    @Override
    public FeatureType getFeatureType() {
        return FeatureType.MOTD;
    }

    @Override
    public void onEnable() {
        randomMOTDMessages = getFeatureConfig().getStringList("random.MOTD");
        randomMOTD = getFeatureConfig().getBoolean(ConfigKey.FEATURE_MOTD_RANDOM.getKey());
    }

    @Override
    public void onDisable() {
        randomMOTDMessages = null;
    }

    @EventHandler
    public void onEvent(final ServerListPingEvent event) {
        if (isEnabled()) {
            String motdMessage = getFeatureConfig().getString("MOTD");

            if (randomMOTD && randomMOTDMessages != null && !randomMOTDMessages.isEmpty()) {
                motdMessage = Utility.getRandomString(randomMOTDMessages);
            }

            event.setMotd(ChatColor.translateAlternateColorCodes('&', motdMessage));
        }
    }
}
