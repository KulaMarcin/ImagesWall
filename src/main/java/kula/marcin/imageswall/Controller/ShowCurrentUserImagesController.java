package kula.marcin.imageswall.Controller;

import kula.marcin.imageswall.Service.UserImageService;
import kula.marcin.imageswall.Service.UserService;
import kula.marcin.imageswall.model.User;
import kula.marcin.imageswall.model.UserImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShowCurrentUserImagesController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserImageService userImageService;

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedUserName = authentication.getName();
        User currentUser = userService.findByUsername(loggedUserName);
        return currentUser;
    }

    @GetMapping("/showCurrentUserImages")
    public String showCurrentUserImages(Model model) {

        User currentUser = getCurrentUser();
        List<UserImage> currentUserImages = userImageService.findAllByUserId(currentUser);
        model.addAttribute("currentUserImages", currentUserImages);
        return "current-user-images";
    }

}
