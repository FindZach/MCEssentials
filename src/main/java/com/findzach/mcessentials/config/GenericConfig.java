package com.findzach.mcessentials.config;

import com.findzach.mcessentials.MCEssentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public abstract class GenericConfig {
    protected final File configFile;
    protected FileConfiguration configuration;
    private boolean newlyCreated = false;

    public GenericConfig(String directory, String fileName) {
        configFile = new File(MCEssentials.getInstance().getDataFolder() + "/" + directory, fileName + ".yml");

        // Check if the config file exists, if not create it.
        if (!configFile.exists()) {
            try {
                createConfigFile();
                newlyCreated = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        configuration = YamlConfiguration.loadConfiguration(configFile);
    }

    private void createConfigFile() throws IOException {
        configFile.getParentFile().mkdirs(); // Ensures the directory exists
        configFile.createNewFile();
    }

    public FileConfiguration getConfig() {
        return configuration;
    }

    public boolean isNewlyCreated() {
        return newlyCreated;
    }

    protected abstract void setConfigDefaults();

    public void save() {
        try {
            configuration.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
