package com.findzach.mcessentials.feature;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
public enum FeatureType {
    ECONOMY("Simple Economy", "economy"),
    FIRST_JOIN("First Join", "firstjoin"),
    SIT("Sit on Blocks", "sit"),
    MOTD("Customizable MOTD Display", "motd"),
    SPAWN("Spawn Management", "spawn"),
    TELEPORT("Teleportation System", "teleport"),
    UPDATER("Updater Service", "updater"),
    VOTE_REWARDS("Simple Vote Rewards System", "vote_rewards");

    private String name;
    private String configName;

    FeatureType(String name, String configName) {
        this.name = name;
        this.configName = configName;
    }

    public String getName() {
        return this.name;
    }

    public String getConfigName() {
        return this.configName;
    }
}

