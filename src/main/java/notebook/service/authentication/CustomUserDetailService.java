package notebook.service.authentication;

import notebook.entity.User;
import notebook.factory.SecurityUserInterface;
import notebook.service.common.BeanProvider;
import notebook.service.user.finduserbyemail.FindUserByEmailService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService {
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    FindUserByEmailService findUserByEmailService = BeanProvider.getBean(FindUserByEmailService.class);

    User user = findUserByEmailService.findUserByEmail(email);

    SecurityUserInterface securityUserInterface = BeanProvider.getBean(SecurityUserInterface.class);
    return securityUserInterface.getConfiguredSecurityUser(user);
  }

}
