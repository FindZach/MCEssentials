package com.findzach.mcessentials.feature;

import com.findzach.mcessentials.feature.impl.misc.Sit;
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
        featureMap.put("VoteFeature", new VotifierAddon());
        featureMap.put("SitFeature", new Sit());
    }

    public void addFeature(String featureName, Feature feature) {
        featureMap.put(featureName, feature);
    }

}
