package com.findzach.mcessentials;

import com.findzach.mcessentials.command.CommandManager;
import com.findzach.mcessentials.config.lang.LanguageManager;
import com.findzach.mcessentials.feature.FeatureManager;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.PlaceholderHook;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCEssentials extends JavaPlugin {

    private static MCEssentials instance;

    private CommandManager commandManager;
    private LanguageManager languageManager;

    private FeatureManager featureManager;

    private boolean PLACE_HOLDER_API_ACTIVE = false;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig(); // if no config exists, this will save the default one from your resources

        String lang = getConfig().getString("language", "lang_en");

        languageManager = new LanguageManager(lang);
        commandManager = new CommandManager();
        featureManager = new FeatureManager();

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            PLACE_HOLDER_API_ACTIVE = true;
        }
    }

    public boolean isPlaceHolderAPILive() {
        return PLACE_HOLDER_API_ACTIVE;
    }


    @Override
    public void onDisable() {
        commandManager = null;
        instance = null;
    }

    public static MCEssentials getInstance() {
        return instance;
    }

    public void reloadPluginConfig() {
        reloadConfig(); // reloads the config if there are changes in the file
        this.languageManager.reloadConfig();
        onDisable();
        onEnable();
    }

    public String getMessage(String path) {
        return languageManager.getConfig().getString(path);
    }
}
