package josh.portal.controller;


import com.github.pagehelper.PageInfo;
import josh.portal.Vo.ImageVo;
import josh.portal.Vo.ProductVo;
import josh.portal.entity.Product;
import josh.portal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @GetMapping("/getproduct/{type}/{pageNum}")
    public Page<Product> getproducts(@PathVariable String type, @PathVariable Integer pageNum) {
        Integer pageSize = 8;
        Page<Product> products = productService.getproducts(type, pageNum - 1, pageSize);
        return products;
    }

    @GetMapping("/image")
    public List<ImageVo> getimage() {
        return productService.getimage();
    }


    @GetMapping("/getproduct/{Id}")
    public Product getproduct(@PathVariable String Id) {
        Long id = Long.parseLong(Id);
        Product p = productService.getproduct(id);
        System.out.println(p);
        return p;
    }
}
