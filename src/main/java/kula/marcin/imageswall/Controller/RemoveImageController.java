package kula.marcin.imageswall.Controller;

import kula.marcin.imageswall.Service.UserImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RemoveImageController {

    @Autowired
    private UserImageService userImageService;

    @GetMapping("/removeImage")
    public String removeImage(@RequestParam("imageToRemoveId") int imageToRemoveId) {
        userImageService.deleteById(imageToRemoveId);
        return "redirect:/showCurrentUserImages";
    }

}
