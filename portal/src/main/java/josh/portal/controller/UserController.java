package josh.portal.controller;

import josh.portal.Vo.UserVo;
import josh.portal.entity.User;
import josh.portal.service.ServiceException;
import josh.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.security.AuthenticationAuditListener;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
@CrossOrigin
@Controller
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    UserService userService;





}
