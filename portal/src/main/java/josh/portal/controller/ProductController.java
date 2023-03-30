package josh.portal.controller;

import josh.portal.Vo.ImageVo;
import josh.portal.entity.Product;
import josh.portal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;


    //根據type 得到productlist
    @GetMapping("/getproduct/{type}")
    public List<Product> getproducts(@PathVariable String type) {
        List<Product> list = productService.getproducts(type);
        return list;
    }

    @GetMapping("/image")
    public List<ImageVo> getimage() {
        return productService.getimage();
    }


}
