package es.projectalpha.antium.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import es.projectalpha.antium.Antium;
import es.projectalpha.antium.login.Manager;
import es.projectalpha.antium.utils.Chat;

public class BlockPlayer implements Listener {

	private Antium plugin;

	public BlockPlayer(Antium Main){
		this.plugin = Main;
		this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();

		if (!Manager.logged.contains(p.getUniqueId())) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();

		if (!Manager.logged.contains(p.getUniqueId())) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockBreak(BlockBreakEvent e){
		Player p = e.getPlayer();

		if (!Manager.logged.contains(p.getUniqueId())) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();

		if (!Manager.logged.contains(p.getUniqueId())) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onDamage(EntityDamageEvent e){
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();

			if (!Manager.logged.contains(p.getUniqueId())) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onInvClick(InventoryClickEvent e){
		if (e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();

			if (!Manager.logged.contains(p.getUniqueId())) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getInventory().getItemInMainHand().getType().equals(Material.COMPASS)) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onTarget(EntityTargetEvent e){
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();

			if (!Manager.logged.contains(p.getUniqueId())) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onInvMove(PlayerItemHeldEvent e){
		Player p = (Player) e.getPlayer();

		if (!Manager.logged.contains(p.getUniqueId())) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onInvClick1(InventoryClickEvent e){
		int slot = e.getSlot();
		Player p = (Player) e.getWhoClicked();

		if (slot == 4) {
			e.setResult(Result.DENY);
		}

		if (!Manager.logged.contains(p.getUniqueId())) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onCommand(PlayerCommandPreprocessEvent e){
		String msg = e.getMessage();
		Player p = (Player) e.getPlayer();

		if ((!Manager.logged.contains(p.getUniqueId())) && (!msg.startsWith("/entrar")) && (!msg.startsWith("/registrar")) && (!msg.startsWith("/register")) && (!msg.startsWith("/login"))) {
			e.setCancelled(true);
			p.sendMessage(Chat.prefix + ChatColor.RED + "Necesitar Entrar/Registrarte al servidor para usar comandos");
		}
	}
}
