package com.findzach.mcessentials.feature.impl.spawn;

import com.findzach.mcessentials.feature.Feature;
import com.findzach.mcessentials.feature.FeatureType;
import org.bukkit.Location;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
public class Spawn extends Feature {
    @Override
    protected void setConfigDefaults() {

    }

    @Override
    public FeatureType getFeatureType() {
        return FeatureType.SPAWN;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public void updateSpawn(Location location) {
        getFeatureConfig().set("spawn.location", location.serialize());
        super.config.save();
    }

}
