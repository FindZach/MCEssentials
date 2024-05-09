package com.findzach.mcessentials.io.config.impl.feature;

import com.findzach.mcessentials.io.config.GenericConfig;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class FeatureConfig extends GenericConfig {

    public FeatureConfig(String featureName) {
        super("feature", featureName);

        if(isNewlyCreated()) {
            setConfigDefaults();  // Set the defaults only if it's newly created
            save();  // Save after setting defaults
        }
    }

    @Override
    public void setConfigDefaults() {
        // Do nothing by default, but can be overridden in subclasses if desired
    }

}
