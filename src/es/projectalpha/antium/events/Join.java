package es.projectalpha.antium.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import es.projectalpha.antium.Antium;
import es.projectalpha.antium.files.Files;
import es.projectalpha.antium.login.Manager;
import es.projectalpha.antium.utils.Chat;

public class Join implements Listener {

	private Antium plugin;

	public Join(Antium Main){
		this.plugin = Main;
		this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		Player p = e.getPlayer();
		Manager.logged.remove(p.getUniqueId());
		Manager.tries.remove(p.getUniqueId());
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		String id = "j";

		p.teleport(new Location(Bukkit.getWorld(Files.config.getString(id + ".mundo")), Files.config.getDouble(id + ".x"), Files.config.getDouble(id + ".y"), Files.config.getDouble(id + ".z"), (float) (Files.config.getDouble(id + ".yaw")), (float) (Files.config.getDouble(id + ".pitch"))));

		ItemStack c = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		ItemMeta cm = c.getItemMeta();
		cm.setDisplayName("ProjectAlpha");
		c.setItemMeta(cm);

		for (int y = 0; y < p.getInventory().getSize(); y++) {
			p.getInventory().setItem(y, c);
		}

		if (!Manager.existPlayer(p)) {
			p.sendMessage(Chat.prefix + ChatColor.RED + "Debes registrarte para poder acceder al servidor");
			p.sendMessage(Chat.prefix + ChatColor.YELLOW + "/registrar <contraseña> <contraseña>");
		} else {
			p.sendMessage(Chat.prefix + ChatColor.RED + "Debes loggearte para poder acceder al servidor");
			p.sendMessage(Chat.prefix + ChatColor.YELLOW + "/entrar <contraseña>");
		}
	}
}
