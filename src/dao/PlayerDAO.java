package dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Skill;
import utility.ConnectionManager;

public class PlayerDAO {
	
	public List<Player> getAllPlayer() throws ClassNotFoundException, SQLException, IOException{
		
		List<Player> playerList = new ArrayList<Player>();
		
		Player player= null;
		
		ConnectionManager con =new ConnectionManager();
		
		Statement st= con.getConnection().createStatement();
		
		String sql=" SELECT * FROM PLAYER";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next())
		{
			player= new Player();
			Long pid= rs.getLong("ID");
			player.setPlayerId(pid);
			String name =rs.getString("NAME");
			player.setName(name);
			String country = rs.getString("COUNTRY");
			player.setCountry(country);
			Long skillid = rs.getLong("SKILLID");
			player.setSkill(skillid);
			playerlist.add(player);
		}
	}
	
	return playerlist;
	
}
