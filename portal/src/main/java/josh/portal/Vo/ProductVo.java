package josh.portal.Vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductVo {
    private String title;
    private String price;
    private String img;
    private String type;
}
