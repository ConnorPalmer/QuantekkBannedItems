package me.connor.qbanneditems;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
  implements Listener
{
  public static List<String> itemban;
  public static List<String> blockban;
  public static List<String> air;
  public static String xc = ChatColor.WHITE + "[" + ChatColor.GOLD + "Quantekk" + ChatColor.WHITE + "] ";

  public void onEnable() {
    saveDefaultConfig();
    itemban = getConfig().getStringList("ItemBan");
    blockban = getConfig().getStringList("BlockBan");
    air = getConfig().getStringList("AirClick");

    getServer().getPluginManager().registerEvents(new Block(), this);
    getServer().getPluginManager().registerEvents(new Item1(), this);
    getServer().getPluginManager().registerEvents(new Item2(), this);
    getServer().getPluginManager().registerEvents(new Item3(), this);
    getServer().getPluginManager().registerEvents(new WorldBlock(), this);
    getServer().getPluginManager().registerEvents(new WorldItem(), this);
    getServer().getPluginManager().registerEvents(this, this);
  }
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    if ((commandLabel.equalsIgnoreCase("BIReload")) && (sender.hasPermission("xc.admin"))) {
      saveConfig();
      getPluginLoader().disablePlugin(this);
      getPluginLoader().enablePlugin(this);
      sender.sendMessage(ChatColor.GREEN + "Banned Items Reloaded");
    }return false;
  }
}