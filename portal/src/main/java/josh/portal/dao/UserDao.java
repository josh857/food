package josh.portal.dao;


import josh.portal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    @Query(value = "select * from User where userName = :username" ,nativeQuery = true)
     User getUserByUserName(String username);
}
