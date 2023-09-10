package com.findzach.mcessentials;

import com.findzach.mcessentials.feature.FeatureType;
import com.findzach.mcessentials.feature.impl.spawn.Spawn;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

import java.util.Map;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
@Setter
public class MCEssentialsConstant {
    private static Location spawn;
    private static Location firstSpawn;
    private static int TELEPORT_DELAY = -1;
    private static boolean SPAWN_TELEPORT_DELAY = true;

    public static Location getFirstSpawn() {
        return firstSpawn;
    }

    public static int getTeleportDelay() {
        if (TELEPORT_DELAY == -1) {
            return 0;
        }
        return TELEPORT_DELAY;
    }

    public static void setSpawn(Location location) {
        spawn = location;
    }
    private void populateIfNull() {

    }
}
