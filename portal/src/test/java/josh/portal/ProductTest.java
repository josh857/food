package josh.portal;

import josh.portal.dao.ProductDao;
import josh.portal.entity.Product;
import josh.portal.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {
    @Autowired
    ProductService productService;
    @Autowired
    ProductDao productDao;
    @Test
    public void getProduct(){
       Product p =  productDao.getproduct(1L);
        System.out.println(p);
    }
}
