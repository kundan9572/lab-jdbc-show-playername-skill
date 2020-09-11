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
		
		
		
		ConnectionManager con =new ConnectionManager();
		
		Statement st= con.getConnection().createStatement();
		
		String sql=" SELECT * FROM PLAYER ORDER BY NAME";
		ResultSet resultSet = st.executeQuery(sql);
		
		Skill skill = null;
		SkillDAO skilldao = new SkillDAO();
		
		while(resultSet.next())
		{
		
			long playerId = resultSet.getLong(1);
			String playerName = resultSet.getString(2);
			String playerCountry = resultSet.getString(3);
			skill = skilldao.getSkillID(resultSet.getLong(4));
			Player player = new Player(playerId, playerName, playerCountry, skill);
			playerList.add(player);

		}
		
		return playerList;

	}
	
}
