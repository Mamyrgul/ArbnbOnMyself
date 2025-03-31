package java16.arbnbonmyself.service.serviceImpl;

import java16.arbnbonmyself.service.FeedbackService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Builder
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

}
