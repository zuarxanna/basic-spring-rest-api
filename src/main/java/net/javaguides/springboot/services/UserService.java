package net.javaguides.springboot.services;

import net.javaguides.springboot.models.entities.User;
import net.javaguides.springboot.models.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User save(User user) {
        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepo.save(user);
    }

    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    public User findOne(Long id) {
        return userRepo.findById(id).get();
    }

    public void removeOne(Long id) {
        userRepo.deleteById(id);
    }

}
