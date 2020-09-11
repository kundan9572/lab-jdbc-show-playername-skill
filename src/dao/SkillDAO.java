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

public class SkillDAO{
	
	public Skill getSkillID(Long ID) throws ClassNotFoundException, SQLException, IOException {
		
	
		
		ConnectionManager con =new ConnectionManager();
		
		Statement st= con.getConnection().createStatement();
		
		String sql=" SELECT * FROM SKILL WHERE ID =" +ID;;
		ResultSet rs = st.executeQuery(sql);
		
		Skill skill = null;
		
		while(rs.next())
		{

			if(rs.getLong("ID") == ID)
			{
				skill = new Skill(rs.getLong("ID"), rs.getString("NAME"));
			}
			
			
		}
		
		return skill;
	}

}