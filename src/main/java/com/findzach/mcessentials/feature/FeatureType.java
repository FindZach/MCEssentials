package com.findzach.mcessentials.feature;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
public enum FeatureType {
    ECONOMY("Simple Economy", "economy", true),
    FIRST_JOIN("First Join", "firstjoin", true),
    SIT("Sit on Blocks", "sit", true),
    MOTD("Customizable MOTD Display", "motd", true),
    SPAWN("Spawn Management", "spawn", true),
    TELEPORT("Teleportation System", "teleport", false),
    UPDATER("Updater Service", "updater", false),
    VOTE_REWARDS("Simple Vote Rewards System", "vote_rewards", true);

    private String name;
    private String configName;

    private boolean isActive;

    FeatureType(String name, String configName, boolean isActive) {
        this.name = name;
        this.configName = configName;
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getName() {
        return this.name;
    }

    public String getConfigName() {
        return this.configName;
    }
}

