package java16.arbnbonmyself.service.serviceImpl;

import java16.arbnbonmyself.service.FavoriteHouseService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Builder
@Transactional
public class FavoriteHouseServiceImpl implements FavoriteHouseService {

}
