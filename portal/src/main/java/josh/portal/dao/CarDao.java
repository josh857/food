package josh.portal.dao;

import josh.portal.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CarDao extends JpaRepository<Car, Long> {
    @Query(value = "select * from Car where product_id = :productid", nativeQuery = true)
    Car getProductById(Long productid);

    @Transactional
    @Modifying
    @Query(value = "update Car set count=:count where id = :id")
    void updatecount(@Param("count") Integer count, @Param("id") Long id);
}
