package com.findzach.mcessentials.content.feature;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.content.feature.impl.economy.EconomyManager;
import com.findzach.mcessentials.content.feature.impl.firstjoin.FirstJoinSetup;
import com.findzach.mcessentials.content.feature.impl.misc.Sit;
import com.findzach.mcessentials.content.feature.impl.motd.MOTD;
import com.findzach.mcessentials.content.feature.impl.spawn.Spawn;
import com.findzach.mcessentials.content.feature.impl.votifier.VotifierAddon;
import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class FeatureManager {
    private Map<FeatureType, Feature> featureMap = new HashMap<>();

    public FeatureManager() {
        initFeatures();
    }

    private void initFeatures() {
        for (FeatureType type: FeatureType.values()) {

            Feature foundFeature = null;
            if (!type.isActive()) continue;

            switch (type) {
                case SIT:
                    foundFeature = new Sit();
                    break;

                case MOTD:
                    foundFeature = new MOTD();
                    break;

                case FIRST_JOIN:
                    foundFeature = new FirstJoinSetup();
                    break;

                case SPAWN:
                    foundFeature = new Spawn();
                    break;

                case ECONOMY:
                    foundFeature = new EconomyManager();
                    break;

                case VOTE_REWARDS:
                    foundFeature = new VotifierAddon();
                    break;
            }

            if (foundFeature != null && foundFeature.isEnabled()) {
                featureMap.put(type, foundFeature);
            } else {
                if (foundFeature == null) {
                    MCEssentials.getInstance().getLogger().info(ChatColor.translateAlternateColorCodes('&', "&c " + type.getName() + " has no connection!"));
                } else {
                    MCEssentials.getInstance().getLogger().info(ChatColor.translateAlternateColorCodes('&', "&c " + foundFeature.getFeatureName() + " is not enabled!"));
                }
            }
        }
    }

    public Feature getFeature(FeatureType featureType) {
        return featureMap.get(featureType);
    }

    public void addFeature(FeatureType featureName, Feature feature) {
        featureMap.put(featureName, feature);
    }

}
