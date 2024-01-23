package com.petex.service;

import java.util.List;

import com.petex.entity.DrAppointmentEntity;

public interface DrAppointmentService {
	
	public Boolean save(DrAppointmentEntity entity);
	
	public List<DrAppointmentEntity> getAllAppointmentData();
	
	public String deleteAppointmentById(Integer customerId);
	
	public DrAppointmentEntity getAppintmentById(Integer customerId);
	
	public Boolean updateAppointmentData(Integer customerId,DrAppointmentEntity entity);

}
