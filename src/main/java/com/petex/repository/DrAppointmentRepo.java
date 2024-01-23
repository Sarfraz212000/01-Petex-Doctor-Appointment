package com.petex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petex.entity.DrAppointmentEntity;

public interface DrAppointmentRepo extends JpaRepository<DrAppointmentEntity, Integer>{

}
