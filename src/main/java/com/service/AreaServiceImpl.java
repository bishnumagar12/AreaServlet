package com.service;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import com.db.DB;
import com.model.Area;

public class AreaServiceImpl implements AreaService {

	@Override
	
	public void calculateAera(Area a)  {
		
		String sql = "insert into calculatearea(length,breadth)values('"+a.getLength()+"','"+a.getBreadth()+"')";
		try {
		Statement st = DB.getConnection().createStatement();
		st.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


