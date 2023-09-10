package com.findzach.mcessentials.feature;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.config.impl.feature.FeatureConfig;
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
        config = new FeatureConfig(getFeatureType().getConfigName());

        if (config.isNewlyCreated()) { // Check if this config was just created
            addIsEnabledConfig();
            setConfigDefaults(); // Feature-specific defaults
            getFeatureConfig().options().copyDefaults(true); // This is crucial to make sure the defaults are copied over.
            config.save(); // Save the defaults to the file
        }

        setActive(getFeatureConfig().getBoolean("isEnabled"));

        if (isActive) {
            enableFeature();
        } else {
            disableFeature();
        }
    }

    private void addIsEnabledConfig() {
        getFeatureConfig().addDefault("isEnabled", true);
    }
    protected abstract void setConfigDefaults();

    public boolean isEnabled() {
        return isActive;
    }

    public FileConfiguration getFeatureConfig() {
        return config.getConfig();
    }

    public void toggleFeature() {
        if (isActive) {
            disableFeature();
        } else enableFeature();
    }

    protected void enableFeature() {
        onEnable();
        MCEssentials.getInstance().getServer().getPluginManager().registerEvents(this, MCEssentials.getInstance());
    }
    protected void disableFeature() {
        onDisable();
    }

    protected void setActive(boolean active) {
        this.isActive = active;
    }

    public abstract FeatureType getFeatureType();
    public abstract void onEnable();
    public abstract void onDisable();

    public String getFeatureName() {
        return getFeatureType().getName();
    }
    public String getFeatureConfigName() {
        return getFeatureType().getConfigName();
    }
}
