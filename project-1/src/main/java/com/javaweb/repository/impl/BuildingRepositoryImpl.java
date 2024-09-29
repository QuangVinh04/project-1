package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.Model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.Entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	static final String url = "jdbc:mysql://localhost:3306/estatebasic?autoReconnect=true&useSSL=false";
    static final String username = "root";
    static final String password = "23082004";
	
    @Override
	public List<BuildingEntity> findAll(String name, Long districtid) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building b WHERE 1 = 1 ");
		if(name != null && !name.equals("")) {
			sql.append("AND b.name LIKE '%" + name + "%' ");
		}
		if(districtid != null) {
			sql.append("AND b.districtid = " + districtid + " ");
		}
		List<BuildingEntity> result = new ArrayList<>();
		try(Connection ketnoi =  DriverManager.getConnection(url, username, password);
				Statement stm = ketnoi.createStatement();	
				ResultSet rs = stm.executeQuery(sql.toString());){
				
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberOfBasement(rs.getInt("numberofbasement"));
				result.add(building);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}