package com.kspl.c2cpass;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class C2cService {
	@Autowired
    private C2cRepository passengerRepository;

    public List<C2c> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public void savePassenger(C2c passenger) {
        passengerRepository.save(passenger);
    }

    public Optional<C2c> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
