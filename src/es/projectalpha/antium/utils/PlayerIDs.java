package es.projectalpha.antium.utils;

import java.util.Random;

public class PlayerIDs {

	public long getRandomID(){
		Random r = new Random();

		return r.nextLong();
	}
}
