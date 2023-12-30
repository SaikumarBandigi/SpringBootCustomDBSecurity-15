package com.springboot.customdbsecurity.Resource;


import com.springboot.customdbsecurity.Repository.UsersRepository;
import com.springboot.customdbsecurity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest/hello")
@RestController
public class HelloResource {

    @Autowired
    private UsersRepository usersRepository;


    @PostMapping("/saveUser")
    public Users saveUser(@RequestBody Users users) {
        return usersRepository.save(users);
    }

    //http://localhost:8080/rest/hello/all -> It does not have any secured keyword ->
    //No Authentication/ No Authorization
    @GetMapping("/all")
    public String hello() {
        return "No Security..You can see this page";
    }

    //localhost:8080/rest/hello/secured/control -> It will be access only for user who is having ADMIN Role
    @PreAuthorize("hasAnyRole('ADMIN')") // Global Level Method Authorization or security (Pre-Defined authorization)
    @GetMapping("/secured/control")
    public String securedAdmin() {
        return "Its secured Page ..And only Admin can view this";
    }

    //localhost:8080/rest/hello/secured/all -> It will be access only for user who is having ADMIN or GUEST Role
    @PreAuthorize("hasAnyRole('GUEST','ADMIN')")
    @GetMapping("/secured/all")
    public String securedGuest() {
        return "Its secured Page ..Both admin and Guest can view this";
    }


}
