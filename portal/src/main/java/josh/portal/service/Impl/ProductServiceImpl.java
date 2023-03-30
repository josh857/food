package josh.portal.service.Impl;

import josh.portal.Vo.ImageVo;
import josh.portal.dao.ProductDao;
import josh.portal.entity.Product;
import josh.portal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;


    @Override
    public List<Product> getproducts(String type) {
        List<Product> list = productDao.getType(type);
        return list;
    }

    @Override
    public List<ImageVo> getimage() {
        List<ImageVo> images = new ArrayList<>();
        List<Product> products = productDao.getimgae();
        for (Product p : products) {
            ImageVo image = new ImageVo();
            image.setImg(p.getImg());
            images.add(image);
        }
        return images;
    }
}
