package com.codewithbrinda.scm.scm0_2.Service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.codewithbrinda.scm.scm0_2.Service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class ImgServiceImpl implements ImgService {


    @Autowired
    private Cloudinary cloudinary;


    @Override
    public String UploadIMG(MultipartFile productimg) {

        String id = UUID.randomUUID().toString();

        try {
            byte[] data = new byte[productimg.getInputStream().available()];
            productimg.getInputStream().read(data);
            cloudinary.uploader().upload(data, ObjectUtils.asMap(
                    "public_id", id));


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }




        return this.getUrlFromPunlicId(id);
    }

    @Override
    public String getUrlFromPunlicId(String punlicId) {
        return cloudinary
                .url()
                .transformation(
                        new Transformation<>()
                                .width(300)
                                .height(300)
                                .crop("fill")
                ).generate(punlicId);



    }
}



