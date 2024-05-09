package com.findzach.mcessentials;

import com.findzach.mcessentials.content.command.CommandManager;
import com.findzach.mcessentials.content.highscore.model.PlayerScore;
import com.findzach.mcessentials.io.config.impl.lang.LanguageManager;
import com.findzach.mcessentials.content.feature.FeatureManager;
import com.findzach.mcessentials.content.feature.impl.economy.SimpleEssentialsEconomy;
import com.findzach.mcessentials.io.net.jetty.DataFetchServlet;
import com.findzach.mcessentials.io.net.jetty.HighscoreMainServlet;
import lombok.Getter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Getter
public final class MCEssentials extends JavaPlugin {

    private static MCEssentials instance;

    private Server webServer;

    private CommandManager commandManager;
    private LanguageManager languageManager;

    private FeatureManager featureManager;

    private boolean PLACE_HOLDER_API_ACTIVE = false;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig(); // if no config exists, this will save the default one from your resources
        saveResource("highscores/index.html", false); // false means don't replace if it exists

        String lang = getConfig().getString("language", "lang_en");

        featureManager = new FeatureManager();

        startServer();

        languageManager = new LanguageManager(lang);
        commandManager = CommandManager.getInstance();

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            PLACE_HOLDER_API_ACTIVE = true;
        }

        for (OfflinePlayer offlinePlayer : Bukkit.getOfflinePlayers()) {
            int ticksPlayed = offlinePlayer.getStatistic(Statistic.PLAY_ONE_MINUTE);
            double hoursPlayed = ticksPlayed / 72000.0;
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.HALF_UP);
            String formattedHours = df.format(hoursPlayed);

            System.out.println("Offline Player: " + offlinePlayer.getName() + " Hours Played: " + formattedHours);
        }

        if (!setupEconomy()) {
            getLogger().severe(String.format("[%s] - No Vault dependency found!", getDescription().getName()));
        }
    }

    public boolean isPlaceHolderAPILive() {
        return PLACE_HOLDER_API_ACTIVE;
    }

    @Override
    public void onDisable() {
        stopServer();
        commandManager = null;
        instance = null;
    }

    private boolean setupEconomy() {
        if (this.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        ServicesManager sm = getServer().getServicesManager();
        sm.register(Economy.class, new SimpleEssentialsEconomy(), this, ServicePriority.Normal);
        return true;
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

    private void startServer() {
        webServer = new Server(8185);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        webServer.setHandler(context);

        // Add a servlet that listens at the root path
        context.addServlet(new ServletHolder(new HighscoreMainServlet()), "/");

        context.addServlet(new ServletHolder(new DataFetchServlet()), "/data");

        try {
            webServer.start();
            // server.join(); // Only if you want to block the current thread.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stopServer() {
        try {
            if (webServer != null) {
                webServer.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getMessage(String path) {
        return languageManager.getConfig().getString(path);
    }

    public List<String> getMessages(String path) {
        return languageManager.getConfig().getStringList(path);
    }

    public int getNumber(String path) {
        return languageManager.getConfig().getInt(path);
    }
}
