package com.findzach.mcessentials.feature.impl.spawn;

import com.findzach.mcessentials.feature.Feature;
import com.findzach.mcessentials.feature.FeatureType;
import org.bukkit.Location;
import org.bukkit.configuration.MemorySection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
