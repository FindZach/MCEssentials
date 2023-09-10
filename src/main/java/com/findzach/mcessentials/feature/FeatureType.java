package com.findzach.mcessentials.feature;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
public enum FeatureType {
    ECONOMY("Simple Economy Integration", "economy"),
    FIRST_JOIN("Seamless First Join Experience", "firstjoin"),
    SIT("Intuitive Sit Functionality", "sit"),
    MOTD("Customizable MOTD Display", "motd"),
    SPAWN("Efficient Spawn Management", "spawn"),
    TELEPORT("Optimized Teleportation System", "teleport"),
    UPDATER("Automatic Updater Service", "updater"),
    VOTE_REWARDS("Configurable Vote Rewards System", "vote_rewards");

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

