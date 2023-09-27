package com.school.OnlineSchool.User;

import java.util.List;

public interface IUserService {
    User add(User user);
    List<User> getAllUsers();
    void delete(String email);
   User getUser(String email);
    User update(User user);
    String Adduser(User user);
}
