package josh.portal.service;

import josh.portal.Vo.UserVo;
import josh.portal.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;

public interface UserService {

    UserDetails getuserDetails(String username);

//    String getcurrentUserName();

//    UserVo getUserVoByUserName();
}
