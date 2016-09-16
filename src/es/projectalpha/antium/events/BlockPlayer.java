package es.projectalpha.antium.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import es.projectalpha.antium.Antium;
import es.projectalpha.antium.login.Manager;

public class BlockPlayer implements Listener {

	private Antium plugin;

	private Manager m;

	public BlockPlayer(Antium Main){
		this.plugin = Main;
		this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
		m = new Manager();
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();

		if(m.players.contains(p)){
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();

		if(m.players.contains(p)){
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockBreak(BlockBreakEvent e){
		Player p = e.getPlayer();

		if(m.players.contains(p)){
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();

		if(m.players.contains(p)){
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onDamage(EntityDamageEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();

			if(m.players.contains(p)){
				e.setCancelled(true);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onInvClick(InventoryClickEvent e){
		if(e.getWhoClicked() instanceof Player){
			Player p = (Player) e.getWhoClicked();

			if(m.players.contains(p)){
				e.setCancelled(true);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onTarget(EntityTargetEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();

			if(m.players.contains(p)){
				e.setCancelled(true);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onInvMove(PlayerItemHeldEvent e){
		Player p = e.getPlayer();

		if(m.players.contains(p)){
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onCommand(PlayerCommandPreprocessEvent e){
		String msg = e.getMessage();
		Player p = e.getPlayer();

		if(m.players.contains(p) && !msg.equalsIgnoreCase("/pin")){
			e.setCancelled(true);
		}
	}
}
