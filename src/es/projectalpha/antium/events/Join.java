package es.projectalpha.antium.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import es.projectalpha.antium.Antium;
import es.projectalpha.antium.files.Files;
import es.projectalpha.antium.login.Manager;
import es.projectalpha.antium.utils.Chat;

public class Join implements Listener {

	private Antium plugin;

	private Manager m;

	public Join(Antium Main){
		this.plugin = Main;
		this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
		m = new Manager();
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		Player p = e.getPlayer();
		m.players.remove(p);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		String id = "j";

		p.teleport(new Location(Bukkit.getWorld(Files.config.getString(id + ".world")), Files.config.getDouble(id + ".x"), Files.config.getDouble(id + ".y"), Files.config.getDouble(id + ".z"), (float) (Files.config.getDouble(id + ".yaw")), (float) (Files.config.getDouble(id + ".pitch"))));

		if(!m.checkPlayer(p)){
			p.sendMessage(Chat.prefix + ChatColor.RED + "You must register to join the server");
			p.sendMessage(Chat.prefix + ChatColor.YELLOW + "/pin <pin> <pin>");
		}else{
			p.sendMessage(Chat.prefix + ChatColor.RED + "You must loggin to join the server");
			p.sendMessage(Chat.prefix + ChatColor.YELLOW + "/pin <pin>");
		}
	}
}
