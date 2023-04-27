package josh.portal.service.Impl;

import josh.portal.dao.CarDao;
import josh.portal.dao.ProductDao;
import josh.portal.entity.Car;
import josh.portal.entity.Product;
import josh.portal.service.CarService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    ProductDao productDao;
    @Autowired
    CarDao carDao;


    @Transactional
    @Override
    public String saveCar(Long productId) {
        //找到Product
        Product p = productDao.getproduct(productId);
        Car c = carDao.getProductById(productId);
        if (c != null) {
            return "已有相同物品";
        }
        Car car = new Car();
        try {
            car.setPrice(p.getPrice());
            car.setImg(p.getImg());
            car.setProductId(p.getId());
            car.setCount(1);
            car.setProductName(p.getName());
            car.setTotal(p.getPrice() * car.getCount());
            Car ca = carDao.save(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "儲存成功";
    }
    public Long getCount() {
        return carDao.count();
    }

    @Override
    public List<Car> getcarts() {
        return carDao.findAll();
    }


    @Transactional
    @Override
    public String updatecountPlus(Long id) {
        if (id == null) {
            return "找不到對應商品id";
        }
        System.out.println(id);
        Car car = carDao.getReferenceById(id);
        Integer count = car.getCount();
        count++;
        System.out.println("count加一" + count);
        carDao.updatecount(count, id);
        return "更新成功";
    }

    @Transactional
    @Override
    public String updatecountLess(Long id) {
        if (id == null) {
            return "找不到對應商品id";
        }
        System.out.println(id);
        Car car = carDao.getReferenceById(id);
        Integer count = car.getCount();
        count--;
        System.out.println("count減一" + count);
        carDao.updatecount(count, id);
        return "更新成功";
    }

    @Transactional
    @Override
    public String deleteById(Long id) {
        carDao.deleteById(id);
        return "刪除成功";
    }
}
