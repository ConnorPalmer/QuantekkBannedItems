package me.connor.qbanneditems;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class WorldItem
  implements Listener
{
  @EventHandler(priority=EventPriority.HIGH)
  public void onWPlace(PlayerInteractEvent e)
  {
    if (e.getPlayer().getWorld().getEnvironment() == World.Environment.NETHER) return;
    Player p = e.getPlayer();
    int ID = p.getItemInHand().getTypeId();
    short D = p.getItemInHand().getDurability();
    if (((Main.witem.contains(ID + ":" + D)) || (Main.wblock.contains(ID + ":*"))) && 
      ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (
      (!p.hasPermission("xc.witem." + ID + ":" + D)) || (!p.hasPermission("xc.witem." + ID + ":*")))) {
      e.setCancelled(true);
      e.getItem().setType(Material.AIR);
      Bukkit.broadcast(Main.xc + p.getName() + ChatColor.RED + " Attempted to Use an Item without Being in the Nether.", "xc.admin");
      p.sendMessage(Main.xc + ChatColor.RED + "NOT ALLOWED");
    }
  }
}