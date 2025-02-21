package com.sms.student.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.student.domain.Location;
import com.sms.student.proxy.LocationProxy;
import com.sms.student.repo.LocationRepo;
import com.sms.student.service.LocationService;
import com.sms.student.util.MapperUtils;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationRepo locationRepo;
	
	@Autowired
	private MapperUtils mapper;
	
	@Override
	public String saveLocation(LocationProxy location) {
		// TODO Auto-generated method stub
		Location l =  mapper.convertlProxyTolEntity(location);
		locationRepo.save(l);
		return "saved successfully";
	}

	@Override
	public List<LocationProxy> getAllLocation() {
		// TODO Auto-generated method stub
		List<LocationProxy>l=mapper.convertlListEntityTolProxy(locationRepo.findAll());
		if(l.isEmpty()) {
			return null;
		}else {
			return l;
		}
	}
	
	@Override
	public LocationProxy getById(Long lid) {
		Location l= locationRepo.findById(lid).get();
		return mapper.convertlEntityTolProxy(l);
	}

	@Override
	public String updateLocationById(Long lid, LocationProxy location) {
		// TODO Auto-generated method stub
		Optional<Location>l= locationRepo.findById(lid);
		if(l.isPresent()) {
			Location lo=l.get();
			lo.setRoad(location.getRoad());
			lo.setArea(location.getArea());
			locationRepo.save(lo);
			return "data successfully updated";
		}else {
			return "id not exist";
		}
	}

	@Override
	public String deleteLocationById(long lid) {
		// TODO Auto-generated method stub
		locationRepo.deleteById(lid);
		return "deleted successfully";
	}

	
}
