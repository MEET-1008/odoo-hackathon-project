package com.codewithbrinda.scm.scm0_2.controller;

import com.codewithbrinda.scm.scm0_2.Service.ImgService;
import com.codewithbrinda.scm.scm0_2.Service.ProductService;
import com.codewithbrinda.scm.scm0_2.Service.UserService;
import com.codewithbrinda.scm.scm0_2.entities.Product;
import com.codewithbrinda.scm.scm0_2.entities.User;
import com.codewithbrinda.scm.scm0_2.forms.ProductForm;
import com.codewithbrinda.scm.scm0_2.helper.Helper;
import com.codewithbrinda.scm.scm0_2.helper.MessageHelper;
import com.codewithbrinda.scm.scm0_2.helper.MessageType;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user/product")
public class ProductConroller {


    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ImgService imgService;


    @GetMapping("/add")
    public String addContactView(Model model, ProductForm productForm, BindingResult result, HttpSession session) {
        System.out.println("********* Get request in contact form ********");
        model.addAttribute("product", productForm);

        if (result.hasErrors()) {
            session.setAttribute("message", MessageHelper.builder().content("Please correct the following errors").type(MessageType.red).build());
            model.addAttribute("product", productForm);
        }

        return "user/add_product";
    }

    @PostMapping("/add")
    public String savecontact(@Valid ProductForm productForm, BindingResult result, Authentication authentication, Model model, HttpSession session) {
        System.out.println("********* post request in product form ********");


        if (result.hasErrors()) {
            session.setAttribute("message", MessageHelper.builder().content("Please correct the following errors").type(MessageType.red).build());
            System.out.println("data nathi malto ");
            model.addAttribute("product", productForm);
            return "user/add_product";
        }


        String username = Helper.getEmailOfLoggedInUser(authentication);
        User user = userService.getUserByEmail(username);
        Product product = getProduct(productForm, user);


        System.out.println(" file name ::------ " + productForm.getProductImage().getOriginalFilename());

        if (productForm.getProductImage().getOriginalFilename() == null ){
            System.out.println("file j nathi aavti ");
        }

        String fileurl = imgService.UploadIMG(productForm.getProductImage());
        System.out.println(" file url " + fileurl);
        product.setProductImage(fileurl);
        productService.save(product);


        session.setAttribute("message", MessageHelper.builder().content("your product added successfully").type(MessageType.green).build());
        model.addAttribute("product", product);

        return "user/add_product";

    }

    private static Product getProduct(ProductForm productForm, User user) {
        Product product = new Product();


        product.setName(productForm.getName());
        product.setFavorite(productForm.getFavorite());
        product.setPrice(productForm.getPrice());
        product.setDescription(productForm.getDescription());
        product.setUser(user);


        return product;
    }


    @GetMapping("byproduct")
    public String viewMyproduct(
            Model model,
            Authentication authentication) {

        // load all the user products
        String username = Helper.getEmailOfLoggedInUser(authentication);

        User user = userService.getUserByEmail(username);

        System.out.println("user " + user);
        List<Product> products = productService.getByUser(user);

        System.out.println(products.toString());

        model.addAttribute("product", products);


        return "user/Listedproduct";
    }


    @GetMapping("/all")
    public String viewAllProduct(
            Model model,
            Authentication authentication) {


        List<Product> products = productService.getAllProduct();

        System.out.println(products.toString());

        model.addAttribute("product", products);


        return "user/allproduct";
    }


}
