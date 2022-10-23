package me.connor.qbanneditems;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Item1
  implements Listener
{
  @EventHandler(priority=EventPriority.HIGH)
  public void ItemUse(PlayerInteractEvent event)
  {
    Player player = event.getPlayer();
    int T = player.getItemInHand().getTypeId();
    short D = player.getItemInHand().getDurability();
    Action act = event.getAction();
    if (((Main.itemban.contains(T + ":" + D)) || (Main.itemban.contains(T + ":*"))) && 
      ((act == Action.RIGHT_CLICK_AIR) || (act == Action.RIGHT_CLICK_BLOCK) || (act == Action.LEFT_CLICK_AIR) || (act == Action.LEFT_CLICK_BLOCK)) && (
      (!player.hasPermission("xc.use." + T + ":" + D)) || (!player.hasPermission("xc.use." + T + ":*")))) {
      event.setCancelled(true);
      event.getItem().setType(Material.AIR);
      player.sendMessage(Main.xc + ChatColor.RED + "You do not have permission to use this item.");
      Bukkit.broadcast(Main.xc + ChatColor.GOLD + player.getName() + " attempted to use " + T + ":" + D, "xcraft.staff");
    }
  }
}