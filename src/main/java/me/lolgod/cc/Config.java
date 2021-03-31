package me.lolgod.cc;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class Config {

  private final Plugin plugin;

  public String no_permission = "§cYou do not have permission!";
  public String null_world = "§cThat world does not exist!";
  public String offline_player = "§cThat player is offline!";
  public String player_chat_cleaned = "§eYour chat was cleaned by %STAFF_NAME%";
  public String all_chat_cleaned = "§eEverybody's chat was cleaned by %STAFF_NAME%";
  public String world_chat_cleaned = "§eThe chat in this world was cleaned by %STAFF_NAME%";

  public Config(Plugin plugin) {
    this.plugin = plugin;

    if (!(new File(plugin.getDataFolder(), "config.yml")).exists()) {
      Bukkit.getConsoleSender().sendMessage("[ChatCleaner] - Config file not found, creating one...");
      plugin.saveDefaultConfig();
    }

    loadValues();
    loadFromConfig();
  }

  public void loadValues() {
    this.plugin.getConfig().addDefault("No-Permission", no_permission);
    this.plugin.getConfig().addDefault("Null-World", null_world);
    this.plugin.getConfig().addDefault("Player-Offline", offline_player);
    this.plugin.getConfig().addDefault("Player-Chat-Cleaned", player_chat_cleaned);
    this.plugin.getConfig().addDefault("All-Chat-Cleaned", all_chat_cleaned);
    this.plugin.getConfig().addDefault("World-Chat-Cleaned", world_chat_cleaned);
    this.plugin.getConfig().options().copyDefaults(true);
  }

  public void loadFromConfig() {
    this.no_permission = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("No-Permission"));
    this.null_world = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Null-World"));
    this.offline_player = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Player-Offline"));
    this.player_chat_cleaned = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Player-Chat-Cleaned"));
    this.all_chat_cleaned = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("All-Chat-Cleaned"));
    this.world_chat_cleaned = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("World-Chat-Cleaned"));
  }

  public void reload() {
    this.plugin.reloadConfig();
    loadValues();
    loadFromConfig();
  }
}
