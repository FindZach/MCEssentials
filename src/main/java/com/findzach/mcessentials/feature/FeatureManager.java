package com.findzach.mcessentials.feature;

import com.findzach.mcessentials.feature.impl.economy.EconomyManager;
import com.findzach.mcessentials.feature.impl.misc.Sit;
import com.findzach.mcessentials.feature.impl.motd.MOTD;
import com.findzach.mcessentials.feature.impl.votifier.VotifierAddon;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class FeatureManager {
    private Map<String, Feature> featureMap = new HashMap<>();

    public FeatureManager() {
        initFeatures();
    }

    private void initFeatures() {
        featureMap.put("Vote-Rewards", new VotifierAddon());
        featureMap.put("Sit-On-Blocks", new Sit());
        featureMap.put("MOTD", new MOTD());
        featureMap.put("Economy", new EconomyManager());
    }

    public void addFeature(String featureName, Feature feature) {
        featureMap.put(featureName, feature);
    }

}
