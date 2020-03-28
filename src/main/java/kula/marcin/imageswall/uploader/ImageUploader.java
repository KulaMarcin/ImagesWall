package kula.marcin.imageswall.uploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {

    private Cloudinary cloudinary;

    public ImageUploader() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "*********",
                "api_key", "***************",
                "api_secret", "****************************"
        ));
    }

    public String uploadFile(String filePath) {
        File file = new File(filePath);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadResult.get("url").toString();
    }
}
