package co.perfectSquare.SpringBootProject.controller;

import co.perfectSquare.SpringBootProject.model.User;
import co.perfectSquare.SpringBootProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // save user
    @PostMapping("/user")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);

    }
    // get Single user
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    //get All user list
    @GetMapping("/user")
    public List<User> getUserList(){
        return userService.getAllUserList();
    }

    //Delete particular user permanently
    @DeleteMapping("/user/{id}/hard")
    public void deleteUserHard(@PathVariable long id){
        userService.deleteUserHard(id);
    }

    //flag particular user as deleted
    @DeleteMapping("/user/{id}/soft")
    public void deleteUserSoft(@PathVariable long id){
        userService.deleteUserSoft(id);
    }

    // update user
    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user,@PathVariable long id){
        return userService.updateUser(user,id);
    }

    //Search User by Name or Surname or pinCode
    @GetMapping("/user/surname/{surname}")
    public List<User> getSearchUserBySurname(@PathVariable String name){
        return userService.searchUserBySurName(name);
    }

    @GetMapping("/user/name/{firstname}")
    public List<User> getSearchUserByName(@PathVariable String firstname){
        return userService.searchUserByName(firstname);
    }

    @GetMapping("/user/pincode/{pinCode}")
    public List<User> getSearchUserByPinCode(@PathVariable String pinCode){
        return userService.searchUserByPinCode(pinCode);
    }

}
