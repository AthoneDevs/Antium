package es.projectalpha.antium.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class Files {

	public static File fileData = new File("plugins/Antium", "data.yml");
	public static YamlConfiguration data = YamlConfiguration.loadConfiguration(fileData);

	public static File fileConfig = new File("plugins/Antium", "config.yml");
	public static YamlConfiguration config = YamlConfiguration.loadConfiguration(fileConfig);

	public static void createFiles(){
		if(!fileData.exists()){
			fileData.mkdir();
		}
		if(!fileConfig.exists()){
			fileConfig.mkdir();

			config.set("Options.Min_Length", 8);
		}
		saveFiles();
	}

	public static void saveFiles(){
		try{
			data.save(fileData);
			config.save(fileConfig);

			data.load(fileData);
			config.load(fileConfig);
		}catch(IOException | InvalidConfigurationException e){
			e.printStackTrace();
		}
	}
}
