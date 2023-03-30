package josh.portal.entity;


import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="nickname")
    private String nickName;

    @Column(name="permission")
    private String Permission;

}
