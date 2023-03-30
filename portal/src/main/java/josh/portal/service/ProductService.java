package josh.portal.service;

import josh.portal.Vo.ImageVo;
import josh.portal.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;

public interface ProductService {

    public List<Product> getproducts(String type);

    public List<ImageVo> getimage();
}
