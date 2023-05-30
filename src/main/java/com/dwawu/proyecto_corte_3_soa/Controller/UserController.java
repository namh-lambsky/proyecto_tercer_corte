package com.dwawu.proyecto_corte_3_soa.Controller;

import com.dwawu.proyecto_corte_3_soa.Model.User;
import com.dwawu.proyecto_corte_3_soa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable long id) {
        return this.userService.getUserById(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User User) {
        return this.userService.saveUser(User);
    }

    @PutMapping(path = "/update-{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User request, @PathVariable long id) {
        User user = userService.getUserById(id);
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setUser_type(request.getUser_type());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        if (request.getReceiptList()!=null) {
            user.setReceiptList(request.getReceiptList());
        }
        return this.userService.saveUser(user);
    }

    @DeleteMapping(path = "/delete-{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable long id) {
        this.userService.deleteUserById(id);
    }

}
