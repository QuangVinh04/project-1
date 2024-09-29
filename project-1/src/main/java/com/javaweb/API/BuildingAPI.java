package com.javaweb.API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.Model.BuildingDTO;
import com.javaweb.Model.ErrorResponseDTO;
import com.javaweb.service.BuildingService;

import customs_exception.FieldRequiredException;

@RestController
public class BuildingAPI {
	@Autowired // dùng để tìm kiểm ra interface khai báo 
	private BuildingService buidingService;
	
	@GetMapping(value = "/api/building")
	@ResponseBody
	public List<BuildingDTO> getbuilding(@RequestParam(name = "name", required = false) String name,
										@RequestParam(name = "districtid", required = false) Long district) {
		List<BuildingDTO> result = buidingService.findAll(name, district); // nhận dữ liệu từ service trả ra
		return result; // trả dữ liệu ra view
	}	
	
//	public void valiDate(BuildingDTO building2) {
//		if(building2.getName() == null || building2.getName() == "" || building2.getNumberOfBasement() == null) {
//			throw new FieldRequiredException("name or numberofbasement is null!");
//		}
//	}
}




