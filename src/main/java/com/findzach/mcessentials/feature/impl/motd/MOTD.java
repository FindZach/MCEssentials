package com.findzach.mcessentials.feature.impl.motd;

import com.findzach.mcessentials.feature.Feature;
import com.findzach.mcessentials.feature.FeatureType;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
public class MOTD extends Feature {

    private boolean isEnabled;

    @Override
    protected void setConfigDefaults() {}

    @Override
    public FeatureType getFeatureType() {
        return FeatureType.MOTD;
    }

    @EventHandler
    public void onEvent(final ServerListPingEvent event) {
        event.setMotd(ChatColor.translateAlternateColorCodes('&', getFeatureConfig().getString("MOTD")));
    }
}
