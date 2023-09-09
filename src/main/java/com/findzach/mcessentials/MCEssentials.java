package com.findzach.mcessentials;

import com.findzach.mcessentials.command.CommandManager;
import com.findzach.mcessentials.command.EssentialsCommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCEssentials extends JavaPlugin {

    private static MCEssentials instance;


    private CommandManager commandManager;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig(); // if no config exists, this will save the default one from your resources

        commandManager = new CommandManager();
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
    }
}
