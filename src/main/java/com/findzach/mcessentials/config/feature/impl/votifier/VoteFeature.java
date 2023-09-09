package com.findzach.mcessentials.config.feature.impl.votifier;

import com.findzach.mcessentials.feature.Feature;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.event.EventHandler;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class VoteFeature extends Feature {

    public VoteFeature() {

    }

    @Override
    protected void setConfigDefaults() {
        getFeatureConfig().addDefault("rewards.commands", new String[]{
                "give %player% diamond 5",
                "eco give %player% 100",
                "say %player% has voted!"
        });
        getFeatureConfig().options().copyDefaults(true); // This is crucial to make sure the defaults are copied over.
    }

    @Override
    protected String getFeatureName() {
        return "VoteFeature";
    }

    @Override
    protected void enableFeature() {

    }

    @Override
    protected void disableFeature() {

    }

    @EventHandler
    public void onVote(VotifierEvent event) {
        System.out.println("We have heard of the vote for: " + event.getVote().getAddress());
        System.out.println("We have heard of the vote for: " + event.getVote().getUsername());
        System.out.println("We have heard of the vote for: " + event.getVote().getTimeStamp());
    }
}
