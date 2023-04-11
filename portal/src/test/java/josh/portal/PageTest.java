package josh.portal;

import josh.portal.dao.ProductDao;
import josh.portal.entity.Product;
import josh.portal.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class PageTest {
    @Autowired
    ProductService productService;
    @Test
    public void pagetest(){
        Page<Product> products = productService.getproducts("1",0,8);

        for(Product p :products.getContent()){
            System.out.println(p);
        }

    }
    @Test
    public void getproduct(){
        Product p = productService.getproduct(1l);
        System.out.println(p);

    }}
