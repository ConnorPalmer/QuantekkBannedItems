package me.connor.qbanneditems;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Item2
  implements Listener
{
  @EventHandler(priority=EventPriority.HIGH)
  public void ItemClick(InventoryClickEvent event)
  {
    Player player = (Player)event.getWhoClicked();
    int T = player.getItemOnCursor().getTypeId();
    short D = player.getItemOnCursor().getDurability();
    if (((Main.itemban.contains(T + ":" + D)) || (Main.itemban.contains(T + ":*"))) && (
      (!player.hasPermission("xcraft.invclick." + T + ":" + D)) || (!player.hasPermission("xcraft.invclick." + T + ":*")))) {
      event.setCancelled(true);
      event.getCurrentItem().setType(Material.AIR);
      player.sendMessage(Main.xc + ChatColor.RED + "You do not have permission to click on this item.");
      Bukkit.broadcast(Main.xc + ChatColor.GOLD + player.getName() + " had " + T + ":" + D + " in his inventory", "xcraft.staff");
    }
  }
}