package me.lolgod.cc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (args.length == 0) {
      commands(sender);
      return false;
    }
    if (args[0].equalsIgnoreCase("-a")) {
      if (sender.hasPermission("cc.world")) {
        Cleaner.clearChatAll(sender);
        return true;
      }

      sender.sendMessage(ChatCleaner.config.no_permission);
      return true;
    }
    if (args[0].equalsIgnoreCase("-p")) {
      if (sender.hasPermission("cc.player")) {
        if (args.length != 2) {
          sender.sendMessage("§aIncorrect use, the command is: /cc -p §c<Player>");
          return false;
        }

        if (Bukkit.getPlayer(args[1]) != null) {
          Cleaner.clearChatPlayer(sender, Bukkit.getPlayer(args[1]));
          return true;
        }

        sender.sendMessage(ChatCleaner.config.offline_player);
      } else {
        sender.sendMessage(ChatCleaner.config.no_permission);
      }
      return true;
    }
    if (args[0].equalsIgnoreCase("-w")) {
      if (sender.hasPermission("cc.world")) {
        Cleaner.clearChatWorld(sender, args[1]);
        return true;
      }

      sender.sendMessage(ChatCleaner.config.no_permission);
      return true;
    }
    if (args[0].equalsIgnoreCase("reload")) {
      if (sender.hasPermission("cc.reload")) {
        ChatCleaner.config.reload();
        sender.sendMessage("§eConfig reloaded");
        return true;
      }

      sender.sendMessage(ChatCleaner.config.no_permission);
      return true;
    }
    return true;
  }

  public void commands(CommandSender sender) {
    sender.sendMessage("§6---- <Chat Cleaner> ----");
    if (sender.hasPermission("cc.all"))
      sender.sendMessage("§eClears everyone's chat:§a /cc -a");
    if (sender.hasPermission("cc.player"))
      sender.sendMessage("§eClears chat for Player:§a /cc -p <Player>");
    if (sender.hasPermission("cc.world"))
      sender.sendMessage("§eClears chat for players in a specific world:§a /cc -w <World Name>");
    if (sender.hasPermission("cc.reload"))
      sender.sendMessage("§eReloads the config file:§a /cc reload");
  }
}