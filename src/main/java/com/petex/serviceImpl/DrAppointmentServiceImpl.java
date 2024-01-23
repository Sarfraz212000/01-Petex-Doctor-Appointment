package com.petex.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petex.entity.DrAppointmentEntity;
import com.petex.repository.DrAppointmentRepo;
import com.petex.service.DrAppointmentService;

@Service
public class DrAppointmentServiceImpl implements DrAppointmentService {

	@Autowired
	private DrAppointmentRepo repo;

	@Override
	public Boolean save(DrAppointmentEntity entity) {
		repo.save(entity);
		return true;
	}

	@Override
	public List<DrAppointmentEntity> getAllAppointmentData() {
		return repo.findAll();
	}

	@Override
	public String deleteAppointmentById(Integer customerId) {

		repo.deleteById(customerId);
		return "deleted";
	}

	@Override
	public DrAppointmentEntity getAppintmentById(Integer customerId) {
		Optional<DrAppointmentEntity> appointmentId = repo.findById(customerId);

		if (appointmentId.isPresent()) {
			return appointmentId.get();
		}
		return null;
	}

	@Override
	public Boolean updateAppointmentData(Integer customerId, DrAppointmentEntity entity) {

		Optional<DrAppointmentEntity> optinalId = repo.findById(customerId);
		if (optinalId.isPresent()) {
			DrAppointmentEntity entites = optinalId.get();
			BeanUtils.copyProperties(entity, entites);
			entites.setCustomerId(customerId);
			repo.save(entites);
			return true;
		}
		return false;
	}

}
