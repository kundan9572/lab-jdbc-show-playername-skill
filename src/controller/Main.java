package controller;

import java.util.ArrayList;
import java.util.List;

import dao.PlayerDAO;
import dao.SkillDAO;
import model.Player;

public class Main {
	public static void main(String[] args) throws Exception {

		// objects of the skillDao and playerDAo
		SkillDAO skillDAO = new SkillDAO();
		PlayerDAO playerDAO = new PlayerDAO();

		// printing the skill details
		System.out.println("List of all players and their skills");
		System.out.println("ID\t Name\t \tCountry\t \tSkill");
		List<Player> players = new ArrayList<Player>();

		players = playerDAO.getAllPlayer();
		for (int i = 0; i < players.size(); i++) {
			System.out.println((i + 1) + ".       " + players.get(i).getName() + "  " + players.get(i).getCountry()
					+ "    " + skillDAO.getSkillID(players.get(i).getSkill().getSkillId()).getSkillName());
		}
	}
}
