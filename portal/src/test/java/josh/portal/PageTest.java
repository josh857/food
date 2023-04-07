package josh.portal;

import josh.portal.dao.ProductDao;
import josh.portal.entity.Product;
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
    ProductDao productDao;
    @Test
    public void pagetest(){
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable  = PageRequest.of(0,8,sort);
        Page<Product> products = productDao.findAll(pageable);
        System.out.println(products.getSize());
        System.out.println(products.getContent());

    }
}
