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
        // Plugin startup logic

        commandManager = new CommandManager();
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MCEssentials getInstance() {
        return instance;
    }
}
