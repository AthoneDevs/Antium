package es.projectalpha.antium.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p;

		if(!(sender instanceof Player)){
			return true;
		}
		p = (Player) sender;

		if(cmd.getName().equalsIgnoreCase("pin")){
			if(args.length == 0){

			}

			if(args.length == 1){

			}
		}
		return false;
	}
}
