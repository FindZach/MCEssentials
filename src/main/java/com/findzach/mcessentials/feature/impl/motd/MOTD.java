package com.findzach.mcessentials.feature.impl.motd;

import com.findzach.mcessentials.config.ConfigKey;
import com.findzach.mcessentials.feature.Feature;
import com.findzach.mcessentials.feature.FeatureType;
import com.findzach.mcessentials.util.Utility;
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

    private List<String> randomMOTDMessages = new ArrayList<>();

    private boolean randomMOTD = getFeatureConfig().getBoolean(ConfigKey.FEATURE_MOTD_RANDOM.getKey());

    @Override
    protected void setConfigDefaults() {}

    @Override
    public FeatureType getFeatureType() {
        return FeatureType.MOTD;
    }

    @Override
    public void onEnable() {
        randomMOTDMessages = getFeatureConfig().getStringList("random.MOTD");
    }

    @Override
    public void onDisable() {
        randomMOTDMessages = null;
    }

    @EventHandler
    public void onEvent(final ServerListPingEvent event) {
        String motdMessage = getFeatureConfig().getString("MOTD");

        if (randomMOTD && randomMOTDMessages != null && !randomMOTDMessages.isEmpty()) {
            motdMessage = Utility.getRandomString(randomMOTDMessages);
        }

        event.setMotd(ChatColor.translateAlternateColorCodes('&', motdMessage));
    }
}
