package com.findzach.mcessentials.feature.impl.motd;

import com.findzach.mcessentials.feature.Feature;
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
    protected String getFeatureName() {
        return "MOTD";
    }

    @Override
    protected void setConfigDefaults() {
        String MOTD = "&a&lEssentialsMC MOTD";

        getFeatureConfig().addDefault("MOTD", MOTD);
    }

    @EventHandler
    public void onEvent(final ServerListPingEvent event) {
        event.setMotd(ChatColor.translateAlternateColorCodes('&', getFeatureConfig().getString("MOTD")));
    }
}
