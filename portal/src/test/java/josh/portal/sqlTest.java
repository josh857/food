package josh.portal;

import jakarta.annotation.Resource;
import josh.portal.dao.CarDao;
import josh.portal.dao.ProductDao;
import josh.portal.dao.UserDao;
import josh.portal.entity.Car;
import josh.portal.entity.Product;
import josh.portal.entity.User;
import josh.portal.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class sqlTest {
    @Resource
    UserDao userDao;
    @Autowired
    ProductDao productDao;

    @Autowired
    CarService carService;

    @Test
    public void sqlTest() {
        User user = new User();
        user.setNickName("josh");
        user.setUserName("josh857");
        user.setPassword("888888");
        user.setPermission("1");
        User u = userDao.save(user);
    }

    @Test
    public void saveproduct() {
        Product product = new Product();
        product.setPrice(40);
        product.setName("紅茶");
        product.setType("2");
        product.setImg("123");
        Product p = productDao.save(product);
    }

    @Test
    public void getproduct() {
        List<Product> products = new ArrayList<>();
        products = productDao.getType("1");
        products.forEach(product -> System.out.println(product));
    }

    @Test
    public void getimage() {
        List<Product> list = productDao.getimgae();
        list.forEach(product -> System.out.println(product));
    }


    @Test
    public void saveCar() {

    }

    @Test
    public void getCar() {
        List<Car> cars = carService.getcarts();
        cars.forEach(car -> System.out.println(car));
    }
}
