package kula.marcin.imageswall.Controller;

import kula.marcin.imageswall.Service.UserImageService;
import kula.marcin.imageswall.Service.UserService;
import kula.marcin.imageswall.model.User;
import kula.marcin.imageswall.model.UserImage;
import kula.marcin.imageswall.uploader.ImageUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UploadImageController {

    @Autowired
    private ImageUploader imageUploader;

    @Autowired
    private UserImageService userImageService;

    @Autowired
    private UserService userService;

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedUserName = authentication.getName();
        User currentUser = userService.findByUsername(loggedUserName);
        return currentUser;
    }

    @PostMapping("/uploadImage")
    public String uploadImag(@RequestParam("imgPathInput") String imgPathInput, Model model) {
        String uploadedImage = imageUploader.uploadFile(imgPathInput);
        model.addAttribute("uploadedImage", uploadedImage);

        User currentUser = getCurrentUser();

        UserImage userImage = new UserImage();
        userImage.setImageUrl(uploadedImage);
        currentUser.add(userImage);
        userService.save(currentUser);

        return "home";
    }

}
