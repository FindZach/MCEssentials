package com.findzach.mcessentials.content.feature.impl.votifier;

import com.findzach.mcessentials.content.feature.Feature;
import com.findzach.mcessentials.content.feature.FeatureType;
import com.findzach.mcessentials.content.util.Messager;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;

import java.util.List;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class VotifierAddon extends Feature {

    public VotifierAddon() {

    }

    @Override
    protected void setConfigDefaults() {
        getFeatureConfig().addDefault("rewards.commands", new String[]{
                "give %player% diamond 5",
                "eco give %player% 100",
                "say %player% has voted!"
        });
    }

    @Override
    public FeatureType getFeatureType() {
        return FeatureType.VOTE_REWARDS;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    protected void enableFeature() {
        super.enableFeature();
    }

    @Override
    protected void disableFeature() {
        super.disableFeature();
    }

    @EventHandler
    public void onVote(VotifierEvent event) {
        if (isEnabled()) {
            List<String> consoleCommands = getFeatureConfig().getStringList("rewards.commands");
            for (String s : consoleCommands) {
                String updatedName = s.replace("%player%", event.getVote().getUsername());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), updatedName);
            }

            for (String broadcast: getFeatureConfig().getStringList("rewards.message")) {
                String updatedBroadcast = broadcast.replaceAll("%playerName%", event.getVote().getUsername());

                Messager.broadcastMessage(updatedBroadcast);
            }
        }
    }
}
