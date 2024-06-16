package ios_project_final.cheermassage.service;

import ios_project_final.cheermassage.entity.CheerMessageEntity;
import ios_project_final.cheermassage.entity.UserEntity;
import ios_project_final.cheermassage.repository.CheerMessageRepository;
import ios_project_final.cheermassage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class CheerMessageService {
    @Autowired
    private CheerMessageRepository cheerMessageRepository;
    @Autowired
    private UserRepository userRepository;

    public void registerNewCheerMessage(String kakao_id,String message_content){ //치어리딩 메시지 등록
        CheerMessageEntity makeCheerMessageEntity=new CheerMessageEntity();
        Optional<UserEntity> userEntity=userRepository.findById(kakao_id);
        makeCheerMessageEntity.setUser(userEntity.get());
        makeCheerMessageEntity.setMessageAddress(userEntity.get().getUserAddress());
        makeCheerMessageEntity.setMessageContent(message_content);
        makeCheerMessageEntity.setMessageDate(LocalDateTime.now());
        makeCheerMessageEntity.setDdabongCount(0);
        cheerMessageRepository.save(makeCheerMessageEntity);
    }

    public void updateDdabongCount(Long messageId) { //따봉카운터 up!
        Optional<CheerMessageEntity> cheerMessageEntityOptional = cheerMessageRepository.findById(messageId);

        if (cheerMessageEntityOptional.isPresent()) {
            CheerMessageEntity cheerMessageEntity = cheerMessageEntityOptional.get();
            int currentDdabong = cheerMessageEntity.getDdabongCount();
            cheerMessageEntity.setDdabongCount(currentDdabong + 1);
            cheerMessageRepository.save(cheerMessageEntity);
        } else {
            // 처리할 메시지가 없는 경우 예외 처리 또는 로깅을 추가할 수 있습니다.
            throw new IllegalArgumentException("Cheer message with id " + messageId + " not found");
        }
    }

    public List<CheerMessageEntity> see(String userAddress){
        if(cheerMessageRepository.findByMessageAddress(userAddress).isEmpty()){
            return null;
        }
        return cheerMessageRepository.findByMessageAddress(userAddress);
    }
}
