package com.exemple.LRcar.LRcar;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import com.exemple.LRcar.LRcar.Model.LRcarModel;
import com.exemple.LRcar.LRcar.Repository.LRcarRepository;
import com.exemple.LRcar.LRcarDTO.LRcarDTO;

@RestController
@RequestMapping("LRcar")
public class LRcarController {

    @Autowired
    private LRcarRepository lrcarRepository;

    @PostMapping
    public ResponseEntity<LRcarModel> createCar(@RequestBody LRcarDTO lrcarDTO) {
        LRcarModel car = new LRcarModel();
        car.setNome(lrcarDTO.nome());
        car.setEmail(lrcarDTO.email());
        car.setCpf(lrcarDTO.cpf());
        car.setTelefone(lrcarDTO.telefone());
        LRcarModel savedCar = lrcarRepository.save(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @GetMapping
    public List<LRcarModel> getAllCars() {
        return lrcarRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LRcarModel> getCarById(@PathVariable UUID id) {
        Optional<LRcarModel> carOptional = lrcarRepository.findById(id);
        if (carOptional.isPresent()) {
            return new ResponseEntity<>(carOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LRcarModel> updateCar(@PathVariable UUID id, @RequestBody LRcarDTO lrcarDTO) {
        Optional<LRcarModel> carOptional = lrcarRepository.findById(id);
        if (carOptional.isPresent()) {
            LRcarModel car = carOptional.get();
            car.setNome(lrcarDTO.nome());
            car.setEmail(lrcarDTO.email());
            car.setCpf(lrcarDTO.cpf());
            car.setTelefone(lrcarDTO.telefone());
            LRcarModel updatedCar = lrcarRepository.save(car);
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable UUID id) {
        Optional<LRcarModel> carOptional = lrcarRepository.findById(id);
        if (carOptional.isPresent()) {
            lrcarRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
