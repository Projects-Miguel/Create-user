package com.create.user.controllers;


import com.create.user.models.entity.Phone;
import com.create.user.models.entity.Username;
import com.create.user.models.services.IUsernameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins ={"*"})
@RestController
@RequestMapping("/api")
public class UsernameRestController {

    @Autowired
    private IUsernameServices usernameServices;

    @GetMapping("/username")
    public List<Username> index(){
        return usernameServices.findAll();
    }

    @GetMapping("/usernames/{id}")
    public Username show(@PathVariable Long id){
        return usernameServices.findById(id);
    }

    @PostMapping("/username")
    @ResponseStatus(HttpStatus.CREATED)
    public Username create(@RequestBody Username username){
        return usernameServices.save(username);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Username update(@RequestBody Username username, @PathVariable Long id){
        Username usuarioActual = usernameServices.findById(id);

        usuarioActual.setName(username.getName());
        usuarioActual.setEmail(username.getEmail());
        usuarioActual.setPhones(username.getPhones());

        return usernameServices.save(usuarioActual);


    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        usernameServices.delete(id);
    }

   @GetMapping("/username/phones")
    public List<Phone> listarPhones(){
        return usernameServices.findAllPhones();
    }

}
