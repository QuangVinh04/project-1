package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.Model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.Entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Override
	public List<BuildingDTO> findAll(String name, Long districtid) {
		// TODO Auto-generated method stub
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(name, districtid);
		List<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(item.getName());
			building.setAddress(item.getStreet() + "," + item.getWard());
			building.setNumberOfBasement(item.getNumberOfBasement());
			result.add(building);
		}
		return result;
	}
	
}
