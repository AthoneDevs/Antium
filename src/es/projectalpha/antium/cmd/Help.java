package es.projectalpha.antium.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import es.projectalpha.antium.login.Manager;

public class Help implements CommandExecutor {

	private Manager m = new Manager();

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
				String pin = args[0];

				m.loginPlayer(p, pin);
			}

			if(args.length == 2){
				String pin = args[0];
				String pin2 = args[1];

				m.registerPlayer(p, pin, pin2);
			}
		}
		return false;
	}
}
