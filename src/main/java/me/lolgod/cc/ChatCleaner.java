package me.lolgod.cc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatCleaner extends JavaPlugin {

  public static Config config;

  public void onEnable() {
    getCommand("chatcleaner").setExecutor(new Commands());

    config = new Config(this);

    Bukkit.getConsoleSender().sendMessage("");
    Bukkit.getConsoleSender().sendMessage("§a[ChatCleaner] -> Plugin enabled!");
    Bukkit.getConsoleSender().sendMessage("§a[ChatCleaner] -> Made by _LolG0D_!");
    Bukkit.getConsoleSender().sendMessage("§a[ChatCleaner] -> You are using version (" + getDescription().getVersion() + ") of this plugin! (There could be an update, check it periodically)");
    Bukkit.getConsoleSender().sendMessage("");
  }

  public void onDisable() {
    saveConfig();

    Bukkit.getConsoleSender().sendMessage("");
    Bukkit.getConsoleSender().sendMessage("§a[ChatCleaner] -> Plugin disabled!");
    Bukkit.getConsoleSender().sendMessage("");
  }
}
