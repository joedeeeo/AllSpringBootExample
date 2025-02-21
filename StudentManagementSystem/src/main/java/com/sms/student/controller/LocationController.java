package com.sms.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.student.proxy.LocationProxy;
import com.sms.student.service.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@PostMapping("/saveLocation")
	public String saveLocation(@RequestBody LocationProxy location) {
		return locationService.saveLocation(location);
	}
	
	@GetMapping("/getAllLocation")
	public List<LocationProxy> getAllLocation(){
		return locationService.getAllLocation();
	}
	
	@GetMapping("/getByLocation/{lid}")
	public LocationProxy getById(@PathVariable Long lid) {
		return locationService.getById(lid);
	}
	
	@PutMapping("/updateByLocationId/{lid}")
	public String updateLocationById(@PathVariable Long lid,@RequestBody LocationProxy location) {
		return locationService.updateLocationById(lid, location);
	}
	
	@DeleteMapping("/deleteByLocationId/{lid}")
	public String deleteLocationById(@PathVariable Long lid) {
		return locationService.deleteLocationById(lid);
	}
}
