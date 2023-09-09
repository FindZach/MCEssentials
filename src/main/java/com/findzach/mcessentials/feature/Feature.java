package com.findzach.mcessentials.feature;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.config.feature.FeatureConfig;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public abstract class Feature implements Listener {

    protected FeatureConfig config; // Every feature now has a config associated with it

    private boolean isActive = false;

    public Feature() {
        config = new FeatureConfig(getFeatureName());
    }

    public boolean isEnabled() {
        return MCEssentials.getInstance().getConfig().getBoolean("feature."+getFeatureName());
    }

    public FileConfiguration getFeatureConfig() {
        return config.getConfig();
    }

    public void toggleFeature() {
        if (isActive) {
            disableFeature();
        } else enableFeature();
    }

    abstract void enableFeature();
    abstract void disableFeature();
    abstract String getFeatureName();
}
