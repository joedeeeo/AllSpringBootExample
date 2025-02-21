package com.sms.student.service;

import java.util.List;

import com.sms.student.proxy.LocationProxy;

public interface LocationService {

	public String saveLocation(LocationProxy location);
	public List<LocationProxy> getAllLocation();
	public String updateLocationById(Long lid,LocationProxy location);
	public String deleteLocationById(long lid);
	public LocationProxy getById(Long lid);
}
