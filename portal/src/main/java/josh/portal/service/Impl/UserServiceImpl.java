package josh.portal.service.Impl;

import josh.portal.Vo.UserVo;
import josh.portal.dao.UserDao;
import josh.portal.entity.User;
import josh.portal.service.ServiceException;
import josh.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collection;
@Service
public class UserServiceImpl implements UserService {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails getuserDetails(String username) {
        User user = userDao.getUserByUserName(username);
        System.out.println(user.getUserName());
        UserDetails u = org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .authorities("/null")
                .build();
        return u;
    }


//    public String getcurrentUserName(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            String username = authentication.getName();
//            return username;
//    }

//    @Override
//    public UserVo getUserVoByUserName() {
//        String name=getcurrentUserName();
//        System.out.println(name);
//        User user = userDao.getUserByUserName(name);
//        UserVo uv = new UserVo();
//            uv.setName(user.getUserName());
//            uv.setNickName(user.getNickName());
//            return uv;
//    }
}
