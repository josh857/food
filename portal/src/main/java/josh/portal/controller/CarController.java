package josh.portal.controller;

import josh.portal.entity.Car;
import josh.portal.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/car")
public class CarController {
    @Autowired
    CarService carService;


    //保存加入購物車後 根據商品id 存取至購物車表
    @PostMapping("/save/{productid}")
    String saveCar(@PathVariable Long productid) {
        return carService.saveCar(productid);

    }

    //獲取購物車內的數量
    @GetMapping( "/getcount")
    Long getCount() {
        return carService.getCount();
    }


    @GetMapping("/getproducts")
    List<Car> getList() {
        List<Car> list = carService.getcarts();
        return list;
    }


    @PutMapping("/updatePlus/{id}")
    String updateCountPlus(@PathVariable Long id) {
        return carService.updatecountPlus(id);
    }

    @PutMapping("/updateLess/{id}")
    String updateCountLess(@PathVariable Long id) {
        return carService.updatecountLess(id);
    }

    @DeleteMapping("/delete/{id}")
    String deleteProduct(@PathVariable Long id) {
        return carService.deleteById(id);
    }
}
