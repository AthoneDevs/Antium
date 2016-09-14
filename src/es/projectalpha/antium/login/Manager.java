package es.projectalpha.antium.login;

import org.bukkit.entity.Player;

import es.projectalpha.antium.files.Files;
import es.projectalpha.antium.utils.PlayerIDs;

public class Manager {

	private PlayerIDs playerids = new PlayerIDs();

	public void registerPlayer(Player p, String pin){
		if(checkPlayer(p)){
			return;
		}

		if(!checkLength(pin)){
			return;
		}

		Files.data.set(p.getName() + ".pin", pin);
		Files.data.set(p.getName() + ".id", playerids.getRandomID());
	}

	public boolean checkLength(String pin){
		if(pin.toCharArray().length < Files.data.getInt("Options.Min_Length")){
			return false;
		}
		return true;
	}

	public String getPin(Player p){
		if(checkPlayer(p)){
			return Files.data.getString(p.getName());
		}
		return "Error";
	}

	public boolean checkPlayer(Player p){
		if(Files.data.contains(p.getName())){
			return true;
		}
		return false;
	}
}
