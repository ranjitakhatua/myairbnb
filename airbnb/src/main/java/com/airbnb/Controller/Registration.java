package com.airbnb.Controller;

import com.airbnb.entity.PropertyUser;
import com.airbnb.payload.PropertyUserDto;
import com.airbnb.repository.PropertyUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reg")
public class Registration {

    private PropertyUserRepository userRepository;

    public Registration(PropertyUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyUser> update(@RequestParam long id, @RequestBody PropertyUserDto dto){
        PropertyUser regi = userRepository.findById(id).get();
        regi.setName(dto.getName());
        regi.setEmail(dto.getEmail());
        regi.setMobile(dto.getMobile());
        PropertyUser save = userRepository.save(regi);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }
}
