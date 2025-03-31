package java16.arbnbonmyself.repo;

import java16.arbnbonmyself.entities.FavoriteHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteHouseRepo extends JpaRepository<FavoriteHouse, Long> {

}
