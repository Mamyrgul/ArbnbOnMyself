package java16.arbnbonmyself.repo;

import java16.arbnbonmyself.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepo extends JpaRepository<House, Long> {

}
