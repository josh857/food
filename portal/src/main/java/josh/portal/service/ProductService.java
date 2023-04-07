package josh.portal.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import josh.portal.Vo.ImageVo;
import josh.portal.Vo.ProductVo;
import josh.portal.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;

public interface ProductService {

     List<Product> getproducts(String type);

     List<ImageVo> getimage();

     String saveProduct(ProductVo pv);

}
