package josh.portal.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="img",columnDefinition = "LONGTEXT")
    private String img;
    @Column(name="price")
    private Integer price;
    @Column(name="type")
    private String type;
}
