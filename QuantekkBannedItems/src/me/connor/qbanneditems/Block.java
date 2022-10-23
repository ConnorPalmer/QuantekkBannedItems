package me.connor.qbanneditems;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class Block
  implements Listener
{
  @EventHandler(priority=EventPriority.HIGH)
  public void Place1(BlockPlaceEvent event)
  {
    Player player = event.getPlayer();
    int T = player.getItemInHand().getTypeId();
    short D = player.getItemInHand().getDurability();
    if (((event.getBlock().equals(Boolean.valueOf(Main.blockban.equals(event.getBlockPlaced().getTypeId() + ":" + event.getBlockPlaced().getData())))) || (event.getBlockPlaced().equals(Boolean.valueOf(Main.blockban.equals(event.getBlockPlaced().getTypeId() + ":*"))))) && (
      (!player.hasPermission("xc.place." + T + ":" + D)) || (!player.hasPermission("xc.place." + T + ":*")))) {
      event.setCancelled(true);
      event.getCurrentItem().setType(Material.AIR);
      player.sendMessage(Main.xc + ChatColor.RED + "Placing " + T + ":" + D + " has been banned.");
      Bukkit.broadcast(Main.xc + ChatColor.GOLD + player.getName() + " attempted to place " + T + ":" + D, "xcraft.staff");
    }
  }
}