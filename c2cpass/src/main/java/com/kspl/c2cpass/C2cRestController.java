package com.kspl.c2cpass;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/passengers")
public class C2cRestController {

	@Autowired
	private C2cService c2cService;

	@GetMapping
	public ResponseEntity<List<C2c>> getAllPassengers() {
		List<C2c> passengers = c2cService.getAllPassengers();
		return new ResponseEntity<>(passengers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<C2c> getPassengerById(@PathVariable("id") long id) {
		Optional<C2c> passenger = c2cService.getPassengerById(id);
		return passenger.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<C2c> savePassenger(@RequestBody C2c passenger) {
		c2cService.savePassenger(passenger);
		return new ResponseEntity<>(passenger, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<C2c> updatePassenger(@PathVariable("id") long id, @RequestBody C2c passengerDetails) {
		Optional<C2c> passenger = c2cService.getPassengerById(id);
		if (passenger.isPresent()) {
			C2c updatedPassenger = passenger.get();
			updatedPassenger.setVisaType(passengerDetails.getVisaType());
			updatedPassenger.setName(passengerDetails.getName());
			updatedPassenger.setMobileNo(passengerDetails.getMobileNo());
			updatedPassenger.setEmail(passengerDetails.getEmail());
			updatedPassenger.setVisaExpDate(passengerDetails.getVisaExpDate());
			c2cService.savePassenger(updatedPassenger);
			return new ResponseEntity<>(updatedPassenger, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePassenger(@PathVariable("id") long id) {
		Optional<C2c> passenger = c2cService.getPassengerById(id);
		if (passenger.isPresent()) {
			c2cService.deletePassenger(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
