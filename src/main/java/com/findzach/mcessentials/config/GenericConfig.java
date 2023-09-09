package com.findzach.mcessentials.config;

import com.findzach.mcessentials.MCEssentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */

public class GenericConfig {
    protected final File configFile;
    protected FileConfiguration configuration;

    public GenericConfig(String directory, String fileName) {
        configFile = new File(MCEssentials.getInstance().getDataFolder() + "/" + directory, fileName + ".yml");

        // Check if the config file exists, if not create it.
        if (!configFile.exists()) {
            try {
                configFile.getParentFile().mkdirs(); // Ensures the directory exists
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        configuration = YamlConfiguration.loadConfiguration(configFile);
    }

    public FileConfiguration getConfig() {
        return configuration;
    }

    public void save() {
        try {
            configuration.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}