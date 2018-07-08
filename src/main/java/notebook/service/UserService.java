package notebook.service;

import notebook.entity.User;

import java.util.List;

public interface UserService {
  User findUserByEmail(String email);
  void saveUser(User user);
  List<User> findAll();
}