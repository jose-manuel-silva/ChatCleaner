package me.lolgod.cc;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cleaner {

  public static void clearChatPlayer(CommandSender sender, Player p) {
    for (int a = 0; a < 100; a++)
      p.sendMessage("");
    p.sendMessage(ChatCleaner.config.player_chat_cleaned.replace("%STAFF_NAME%", sender.getName()));
  }

  public static void clearChatWorld(CommandSender sender, String world) {
    if (Bukkit.getWorld(world) == null) {
      sender.sendMessage(ChatCleaner.config.null_world);
      return;
    }

    Bukkit.getOnlinePlayers().forEach(all -> {
      if (!all.getWorld().getName().equalsIgnoreCase(world))
        return;

      for (int a = 0; a < 100; a++)
        all.sendMessage("");
      all.sendMessage(ChatCleaner.config.world_chat_cleaned.replace("%STAFF_NAME%", sender.getName()));
    });
  }

  public static void clearChatAll(CommandSender sender) {
    Bukkit.getOnlinePlayers().forEach(all -> {
      for (int a = 0; a < 100; a++)
        all.sendMessage("");
      all.sendMessage(ChatCleaner.config.all_chat_cleaned.replace("%STAFF_NAME%", sender.getName()));
    });
  }
}
