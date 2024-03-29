package com.petex.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DRAPPOINTMENT_TAB")
public class DrAppointmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

	private String customerName;

	private String customerEmail;
	
	private Long customerPhno;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate date;

	@JsonFormat(pattern = "H:mm")
	private LocalTime time;

	private String description;

}
