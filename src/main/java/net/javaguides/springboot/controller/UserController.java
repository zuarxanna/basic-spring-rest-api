package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.ResponseData;
import net.javaguides.springboot.models.entities.User;
import net.javaguides.springboot.services.UserService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseData<User>> create(@Valid @RequestBody User user, Errors errors ){
        ResponseData<User> responseData = new ResponseData<>();
        if(errors.hasErrors()) {
            for (ObjectError error: errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(userService.save(user));
        responseData.getMessage().add("User successfully created!");
        return ResponseEntity.ok(responseData);
     }

    @GetMapping
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") Long id) {
        return userService.findOne(id);
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.removeOne(id);
    }



}
