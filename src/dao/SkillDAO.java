package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO
{
	 public Skill getSkillBylD(Long id) throws ClassNotFoundException, SQLException, IOException 
	   {
		 Connection con = ConnectionManager.getConnection();
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery("SELECT * FROM skill");
		 Skill skill = new Skill();
		 while(rs.next())
		 	{
			 long checkid = rs.getLong(1);
			 if(checkid==id)
			 {
				 String name = rs.getString(2);
				 skill.setSkillId(checkid);
				 skill.setSkillName(name);
				 return skill;
			 }
			}
		return null;
	 
	}
	 
}