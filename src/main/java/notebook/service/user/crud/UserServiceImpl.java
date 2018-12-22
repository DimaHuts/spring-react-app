package notebook.service.user.crud;

import notebook.entity.User;
import notebook.repository.user.UserRepository;
import notebook.service.common.BeanProvider;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Override
  public void saveUser(User user) {
    UserRepository userRepository = BeanProvider.getBean(UserRepository.class);

    userRepository.save(user);
  }
}