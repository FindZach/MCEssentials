package com.findzach.mcessentials.config;

import com.findzach.mcessentials.MCEssentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public abstract class GenericConfig {
    protected final File configFile;
    protected FileConfiguration configuration;
    private boolean newlyCreated = false;

    public GenericConfig(String directory, String fileName) {
        configFile = new File(MCEssentials.getInstance().getDataFolder() + "/" + directory, fileName + ".yml");

        // Check if the config file exists, if not create it.
        if (!configFile.exists()) {
            try {
                // First, try copying from resources.
                if (!copyFromResources(directory, fileName)) {
                    // If not in resources, then create a new file.
                    createConfigFile();
                    newlyCreated = true;
                }
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

    private boolean copyFromResources(String directory, String fileName) throws IOException {
        // Try to get the file from the resources.
        System.out.println("Directory: " + directory + " fileName: " + fileName);
        InputStream in = MCEssentials.getInstance().getResource(directory + "/" + fileName + ".yml");
        if (in == null) {
            System.out.println("There is no file input at: " + (directory + "/" + fileName + ".yml"));
            return false;
        }

        Files.copy(in, configFile.toPath());
        return true;
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
