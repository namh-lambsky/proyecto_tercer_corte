package com.dwawu.proyecto_corte_3_soa.Service;

import com.dwawu.proyecto_corte_3_soa.Model.User;
import com.dwawu.proyecto_corte_3_soa.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Transactional
    public User saveUser(User User){
        return userRepo.save(User);
    }

    @Transactional
    public void deleteUserById(long id){
        userRepo.deleteById(id);
    }

}
