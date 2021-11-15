package co.perfectSquare.SpringBootProject.service;

import co.perfectSquare.SpringBootProject.model.User;

import java.util.List;

public interface UserService {

    public void saveUser(User user);

    public List<User> getAllUserList();

    public User getUser(long id);

    public void deleteUserSoft(long id);

    public void deleteUserHard(long id);

    public User updateUser(User user ,long id);

    public List<User> searchUserByName(String name);

    public List<User> searchUserBySurName(String name);

    public List<User> searchUserByPinCode(String name);
}
