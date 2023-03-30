package josh.portal.entity;


import jakarta.persistence.*;
import lombok.Data;

import org.springframework.data.annotation.Id;




@Data
@Entity
@Table(name="Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_count")
    private Integer count;
    @Column(name="product_price")
    private Integer price;
    @Column(name="product_total")
    private Integer total;
    @Column(name="product_img" ,columnDefinition = "LONGTEXT")
    private String img;
    @Column(name="product_id")
    private Long productId;

}
