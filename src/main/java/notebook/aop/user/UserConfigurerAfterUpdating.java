package notebook.aop.user;

import notebook.factory.AuthenticationFactory;
import notebook.service.authentication.authenticationmanager.AuthenticationManagerInterface;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import notebook.entity.User;
import notebook.service.common.BeanProvider;
import notebook.service.user.updateuserpassword.UpdateUserPasswordService;
import notebook.service.user.updateuserrole.UpdateUserRoleService;

@Aspect
@Component
public class UserConfigurerAfterUpdating {
	@Before("execution(* notebook.controller.UsersController.updateUser(..)) && args(user)")
  public void beforeUserUpdate(User user) {
    UpdateUserPasswordService updateUserPasswordService = BeanProvider.getBean(UpdateUserPasswordService.class);
    updateUserPasswordService.updateUserPassword(user);
  	
    UpdateUserRoleService updateUserRoleService = BeanProvider.getBean(UpdateUserRoleService.class);
    updateUserRoleService.updateUserRole(user);

    AuthenticationFactory authenticationFactory = new AuthenticationFactory();
    Authentication authentication = authenticationFactory.getAuthenticationObject(user);

    AuthenticationManagerInterface authenticationManager = BeanProvider.getBean(AuthenticationManagerInterface.class);
    authenticationManager.authenticate(authentication);
  }
}
