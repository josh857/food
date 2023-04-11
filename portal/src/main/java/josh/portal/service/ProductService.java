package josh.portal.service;


import com.github.pagehelper.PageInfo;
import josh.portal.Vo.ImageVo;
import josh.portal.Vo.ProductVo;
import josh.portal.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;

public interface ProductService {

//     List<Product> getproducts(String type);
     //獲得指定type 並分頁商品
     Page<Product> getproducts(String type, Integer pageNum , Integer pageSize);
     //根據id 獲得 product
     Product getproduct(Long Id);
     //獲得image訊息
     List<ImageVo> getimage();
     //存取Product 訊息
     String saveProduct(ProductVo pv);

}
