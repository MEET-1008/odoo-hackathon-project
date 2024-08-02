package com.codewithbrinda.scm.scm0_2.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductForm {

    @NotBlank(message = "product name is Required..")
    @Size(min = 3 , message = "min 3 characters required..")
    private String name;

    @NotBlank(message = "price is Required..")
    private String price;

    private String description;

    private Boolean favorite=false;

    private MultipartFile productImage;

}
