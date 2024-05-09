package com.findzach.mcessentials.io.config.impl.lang;

import com.findzach.mcessentials.MCEssentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LanguageManager {

    private FileConfiguration langConfig = null;
    private File configFile = null;
    private final String lang;

    public LanguageManager(String lang) {
        this.lang = lang;
        saveDefaultConfig();
        reloadConfig();
    }

    public void reloadConfig() {
        if (configFile == null) {
            configFile = new File(MCEssentials.getInstance().getDataFolder() + "/lang", lang + ".yml");
        }

        // Load configuration from the file on the disk
        langConfig = YamlConfiguration.loadConfiguration(configFile);

        // Set the defaults from the JAR
        InputStream defaultStream = MCEssentials.getInstance().getResource("lang/" + lang + ".yml");
        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            langConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getConfig() {
        if (langConfig == null) {
            reloadConfig();
        }
        return langConfig;
    }

    public String getMessage(String key) {
        return langConfig.get(key, langConfig.getDefaults().get(key)).toString();
    }

    private void saveDefaultConfig() {
        if (configFile == null) {
            configFile = new File(MCEssentials.getInstance().getDataFolder() + "/lang", lang + ".yml");
        }

        if (!configFile.exists()) {
            MCEssentials.getInstance().saveResource("lang/" + lang + ".yml", false);
        }
    }
}
