package com.github.kamila21y.testflyplugin;

import com.github.kamila21y.testflyplugin.commands.FlyCMD;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestFlyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fly").setExecutor((CommandExecutor) new FlyCMD(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
