package es.projectalpha.antium.login;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import es.projectalpha.antium.files.Files;
import es.projectalpha.antium.utils.PlayerIDs;

public class Manager {

	private PlayerIDs playerids = new PlayerIDs();

	public ArrayList<Player> players = new ArrayList<Player>();

	public void registerPlayer(Player p, String pin, String pin2){
		if(checkPlayer(p)){
			return;
		}

		if(!checkLength(pin)){
			return;
		}

		if(!isSamePin(pin, pin2)){
			return;
		}

		Files.data.set(p.getName() + ".pin", pin);
		Files.data.set(p.getName() + ".id", playerids.getRandomID());
		Files.data.set(p.getName() + ".uuid", p.getUniqueId());

		Files.saveFiles();

		players.remove(p);
	}

	public void loginPlayer(Player p, String pin){
		if(!getPin(p).equalsIgnoreCase(pin)){
			return;
		}

		players.remove(p);
	}

	public boolean isSamePin(String pin, String pin2){
		if(pin.equalsIgnoreCase(pin2)){
			return true;
		}
		return false;
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
