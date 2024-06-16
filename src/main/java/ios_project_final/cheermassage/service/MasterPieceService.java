package ios_project_final.cheermassage.service;

import ios_project_final.cheermassage.entity.MasterPieceEntity;
import ios_project_final.cheermassage.repository.MasterPieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
public class MasterPieceService {
    @Autowired
    private MasterPieceRepository masterpieceRepository;

    //랜덤한 이미지 하나를 제공
    public MasterPieceEntity getRandomMasterpiece() {
        List<MasterPieceEntity> allMasterpieces = masterpieceRepository.findAll();
        if (allMasterpieces.isEmpty()) {
            // 예외 처리 또는 기본값 반환 등을 할 수 있음
            return null;
        }

        // 랜덤 인덱스 생성
        Random random = new Random();
        int randomIndex = random.nextInt(allMasterpieces.size());

        return allMasterpieces.get(randomIndex);
    }

    public void updateJoayuCount(Long masterpieceId){ //명작의 좋아요 카운터 up
        Optional<MasterPieceEntity> masterPieceEntity=masterpieceRepository.findById(masterpieceId);
        if(masterPieceEntity.isPresent()){
            MasterPieceEntity updateMasterPieceEntity=masterPieceEntity.get();
           int tmpCount= updateMasterPieceEntity.getJoayuCount();
            updateMasterPieceEntity.setJoayuCount(tmpCount+1);
            masterpieceRepository.save(updateMasterPieceEntity);
        }
        else{
            //원래라면 널 에러 처리
        }
    }
}
