package java16.arbnbonmyself.repo;

import java16.arbnbonmyself.entities.AddressDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDetailRepo extends JpaRepository<AddressDetail, Long> {
}
