package josh.portal.service;

import josh.portal.entity.Car;

import java.util.List;

public interface CarService {

    String saveCar(Long productId);

    Long getCount();

    List<Car> getcarts();

    String updatecountPlus(Long id);

    String updatecountLess(Long id);

    String deleteById(Long id);

}
