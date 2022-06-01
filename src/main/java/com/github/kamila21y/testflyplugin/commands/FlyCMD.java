package com.github.kamila21y.testflyplugin.commands;

import com.github.kamila21y.testflyplugin.TestFlyPlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FlyCMD implements CommandExecutor {

    private TestFlyPlugin plugin;

    public FlyCMD(TestFlyPlugin plugin) {
        this.plugin = plugin;
    }

    List<String> playersfly = new ArrayList<String>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&cYou can only run this command from within the game."));
            return true;
        }

        Player player = (Player)sender;

        if (!playersfly.contains(player.getName())){

            playersfly.add(player.getName());
            player.setAllowFlight(true);
            player.setFlying(true);
            player.setFlySpeed(1);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aFly&8] &cFly Mode Enabled."));

            return true;

        } else {

            playersfly.remove(player.getName());
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aFly&8] &cFly Mode Enabled."));

        }

        return true;
    }
}
