package me.connor.qbanneditems;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class WorldBlock
  implements Listener
{
  @EventHandler(priority=EventPriority.HIGH)
  public void onWPlace(BlockPlaceEvent e)
  {
    if (e.getPlayer().getWorld().getEnvironment() == World.Environment.NETHER) return;
    Player p = e.getPlayer();
    int ID = e.getBlock().getTypeId();
    short D = e.getBlock().getData();
    if (((Main.wblock.contains(ID + ":" + D)) || (Main.wblock.contains(ID + ":*"))) && (
      (!p.hasPermission("xc.wblock." + ID + ":" + D)) || (!p.hasPermission("xc.wblock." + ID + ":*")))) {
      e.setCancelled(true);
      e.getItemInHand().setType(Material.AIR);
      Bukkit.broadcast(Main.xc + p.getName() + ChatColor.RED + " Attempted to Place a Block without Being in the Nether.", "xc.admin");
      p.sendMessage(Main.xc + ChatColor.RED + "NOT ALLOWED");
    }
  }
}