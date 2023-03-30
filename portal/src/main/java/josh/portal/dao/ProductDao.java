package josh.portal.dao;

import josh.portal.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    @Query(value = "select  *  from Product where type = :type order by price asc ", nativeQuery = true)
    List<Product> getType(@Param("type") String type);

    @Query(value = "select * from Product limit 3", nativeQuery = true)
    List<Product> getimgae();

    @Query(value = "select * from Product  where id=:productid", nativeQuery = true)
    Product getproduct(Long productid);
}
