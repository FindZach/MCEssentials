package com.findzach.mcessentials.util;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class UpdateChecker {

    private final JavaPlugin plugin;
    private final String localVersion;
    private final String remoteUrl;

    public UpdateChecker(JavaPlugin plugin, String remoteUrl) {
        this.plugin = plugin;
        this.localVersion = plugin.getDescription().getVersion();
        this.remoteUrl = remoteUrl;
    }

    public void checkForUpdates() {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(remoteUrl).openConnection();
                connection.setRequestMethod("GET");
                String latestVersion = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();

                if (latestVersion != null && !latestVersion.equals(localVersion)) {
                    Bukkit.getConsoleSender().sendMessage("[MCEssentials] A new version is available: " + latestVersion);
                }

            } catch (Exception e) {
                Bukkit.getConsoleSender().sendMessage("[MCEssentials] Update check failed: " + e.getMessage());
            }
        });
    }
}