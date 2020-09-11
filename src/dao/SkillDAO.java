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
		
		
		
		
		List<Skill> skillList = new ArrayList<Skill>();
		
		Skill skill= null;
		
		ConnectionManager con =new ConnectionManager();
		
		Statement st= con.getConnection().createStatement();
		
		String sql=" SELECT * FROM SKILL";
		ResultSet rs = st.executeQuery(sql);
		
		
		
		while(rs.next())
		{
			skill = new Skill();
			Long skillid = rs.getLong("SKILLID");
			skill.setSkillId(skillid);
			String name = rs.getString("NAME");
			skill.setSkillName(name);
			skillList.add(skill);
		}
		
		
	}

}