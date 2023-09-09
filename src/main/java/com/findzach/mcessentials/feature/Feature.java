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

    private boolean isActive = true;

    public Feature() {
        config = new FeatureConfig(getFeatureName());
        if (config.isNewlyCreated()) { // Check if this config was just created
            setConfigDefaults(); // Feature-specific defaults
            config.save(); // Save the defaults to the file
        }
        MCEssentials.getInstance().getServer().getPluginManager().registerEvents(this, MCEssentials.getInstance());
    }
    protected abstract void setConfigDefaults();
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

    protected abstract void enableFeature();
    protected abstract void disableFeature();
    protected abstract String getFeatureName();
}
