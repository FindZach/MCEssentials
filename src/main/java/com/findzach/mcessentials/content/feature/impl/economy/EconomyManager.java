package com.findzach.mcessentials.content.feature.impl.economy;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.content.feature.Feature;
import com.findzach.mcessentials.content.feature.FeatureType;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
public class EconomyManager extends Feature {
    @Override
    protected void setConfigDefaults() {//File Generated from Resources
    }

    @Override
    public FeatureType getFeatureType() {
        return FeatureType.ECONOMY;
    }

    public static String getPluralCurrency() {
        return MCEssentials.getInstance().getFeatureManager().getFeature(FeatureType.ECONOMY).getFeatureConfig().getString("economy-details.currency-name-plural");
    }

    public static String getSingularCurrency() {
        return MCEssentials.getInstance().getFeatureManager().getFeature(FeatureType.ECONOMY).getFeatureConfig().getString("economy-details.currency-name-singular");
    }
    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

}
