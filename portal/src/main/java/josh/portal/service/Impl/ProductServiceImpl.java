package josh.portal.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import josh.portal.Vo.ImageVo;
import josh.portal.Vo.ProductVo;
import josh.portal.dao.ProductDao;
import josh.portal.entity.Product;
import josh.portal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;


    @Override
    public List<Product> getproducts(String type ) {
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


    public static String tobase64(String filename) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(filename);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(Base64Coder.encode(data));

    }



    @Transactional
    @Override
    public String saveProduct(ProductVo pv) {
            String imgbase64 =tobase64(pv.getImg());
            System.out.println(imgbase64);
            Product p = new Product();
            p.setPrice(Integer.parseInt(pv.getPrice()));
            p.setName(pv.getTitle());
            p.setImg("data:image/png;base64,"+imgbase64);
            p.setType(pv.getType());
            productDao.save(p);
            return "儲存成功";
    }
}
