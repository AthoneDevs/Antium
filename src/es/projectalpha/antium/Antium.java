package es.projectalpha.antium;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import es.projectalpha.antium.cmd.Help;
import es.projectalpha.antium.events.BlockPlayer;
import es.projectalpha.antium.events.Join;
import es.projectalpha.antium.files.Files;
import es.projectalpha.antium.utils.Chat;

public class Antium extends JavaPlugin {

	@Override
	public void onEnable(){

		registerCommands();
		registerEvents();
		Files.createFiles();

		Bukkit.getConsoleSender().sendMessage(Chat.prefix + ChatColor.GREEN + "Antium Enabled");
	}

	private void registerEvents(){
		new Join(this);
		new BlockPlayer(this);
	}

	private void registerCommands(){
		getCommand("registrar").setExecutor(new Help());
		getCommand("entrar").setExecutor(new Help());
		getCommand("antium").setExecutor(new Help());
	}
}
