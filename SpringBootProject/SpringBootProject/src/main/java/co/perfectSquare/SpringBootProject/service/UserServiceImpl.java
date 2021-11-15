package co.perfectSquare.SpringBootProject.service;

import co.perfectSquare.SpringBootProject.dao.UserRepository;
import co.perfectSquare.SpringBootProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;


    public void saveUser(User user){
        if(user != null){
            userRepository.save(user);
        }
    }


    public List<User> getAllUserList(){
        List<User> all = userRepository.findAll();
        List<User> retUser= new ArrayList<>();
        ListIterator<User> itr = all.listIterator();
        while(itr.hasNext()){
            User user = itr.next();
            if(!user.getDeleteStatus()){
                retUser.add(user);
            }
        }
        return retUser;
    }

    public User getUser(long id){
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUserSoft(long id) {
        User user = userRepository.findById(id).get();
        user.setDeleteStatus(true);
        userRepository.save(user);
    }

    @Override
    public void deleteUserHard(long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user ,long id){
            userRepository.save(user);
            return user;
    }

    @Override
    public List<User> searchUserByName(String name) {
        List<User> user = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        Iterator<User> itrIterator = user.listIterator();
        while (itrIterator.hasNext()){
            User next = itrIterator.next();
            if (next.getFirstName().equals(name)){
                userList.add(next);
            }
        }
        return userList;
    }

    @Override
    public List<User> searchUserBySurName(String name) {
        List<User> user = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        Iterator<User> itrIterator = user.listIterator();
        while (itrIterator.hasNext()){
            User next = itrIterator.next();
            if (next.getLastName().equals(name)){
                userList.add(next);
            }
        }
        return userList;
    }

    @Override
    public List<User> searchUserByPinCode(String name) {
        List<User> user = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        Iterator<User> itrIterator = user.listIterator();
        while (itrIterator.hasNext()){
            User next = itrIterator.next();
            if (next.getPinCode().equals(name)){
                userList.add(next);
            }
        }
        return userList;
    }
}
