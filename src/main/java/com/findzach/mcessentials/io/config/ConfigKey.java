package com.findzach.mcessentials.io.config;

/**
 * @author Zach (zach@findzach.com)
 * @since 9/10/2023
 */
public enum ConfigKey {

    PLUGIN_PREFIX("basic.prefix"),
    ERROR_MSG_INVALID_USER("error.invalid-player"),

    FLY_SELF("fly.self"),
    FLY_OTHER("fly.other"),

    GMC_SELF("gmc.self"),
    GMC_OTHER("gmc.other"),

    GMA_SELF("gma.self"),
    GMA_OTHER("gma.other"),

    GMS_SELF("gms.self"),
    GMS_OTHER("gms.other"),

    GMSPEC_SELF("gmspec.self"),
    GMSPEC_OTHER("gmspec.other"),

    FEATURE_MOTD_RANDOM("enableRandomMOTD"),


    PING("basic.ping")
    ;


    private String key;
    ConfigKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
