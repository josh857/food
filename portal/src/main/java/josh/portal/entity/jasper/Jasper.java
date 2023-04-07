package josh.portal.entity.jasper;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="jasper")
public class Jasper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="age")
    private String age;
    @Column(name="name")
    private String name;
    @Column(name="gender")
    private String gender;
}
