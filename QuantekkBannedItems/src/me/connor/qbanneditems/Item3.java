package me.connor.qbanneditems;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class Item3
  implements Listener
{
  @EventHandler(priority=EventPriority.HIGH)
  public void Pickup(PlayerPickupItemEvent event)
  {
    Player player = event.getPlayer();
    int T = event.getItem().getItemStack().getTypeId();
    short D = event.getItem().getItemStack().getDurability();
    if (((Main.itemban.contains(T + ":" + D)) || (Main.itemban.contains(T + ":*"))) && (
      (!player.hasPermission("xc.pickup." + T + ":" + D)) || (!player.hasPermission("xc.pickup" + T + ":*")))) {
      event.setCancelled(true);
      player.sendMessage(Main.xc + ChatColor.RED + "You do not have permission to pickup this item.");
      Bukkit.broadcast(Main.xc + ChatColor.GOLD + player.getName() + " attempted to pickup " + T + ":" + D, "xcraft.staff");
    }
  }
}