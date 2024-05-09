package com.findzach.mcessentials.content.feature.impl.spawn;

import com.findzach.mcessentials.content.feature.Feature;
import com.findzach.mcessentials.content.feature.FeatureType;
import org.bukkit.Location;
import org.bukkit.configuration.MemorySection;

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

    public Location getSpawn() {
        if (!getFeatureConfig().getBoolean("spawn.set")) {
            return null;
        }
        MemorySection section = (MemorySection) getFeatureConfig().get("spawn.location");
        return Location.deserialize(section.getValues(false)); // the boolean parameter determines if defaults should be included
    }

    public void updateSpawn(Location location) {
        getFeatureConfig().set("spawn.location", location.serialize());
        getFeatureConfig().set("spawn.set", true);
        super.config.save();
    }

}
