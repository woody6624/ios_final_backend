package ios_project_final.cheermassage.service;

import ios_project_final.cheermassage.entity.TouristAttractionEntity;
import ios_project_final.cheermassage.repository.TouristAttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class TouristAttractionService {

    @Autowired
    TouristAttractionRepository touristAttractionRepository;

    //서울 명소 정보를 리턴
    public TouristAttractionEntity getTourist(String seoul_gu){
        Optional<TouristAttractionEntity> touristAttractionEntity=touristAttractionRepository.findById(seoul_gu);
        TouristAttractionEntity send=touristAttractionEntity.get();
        return send;
    }

    public TouristAttractionEntity increaseJoayuCount(String seoul_gu){
        Optional<TouristAttractionEntity> touristAttractionEntity=touristAttractionRepository.findById(seoul_gu);
        TouristAttractionEntity send=touristAttractionEntity.get();
        int tmpCount=send.getJoayuCount()+1;
        send.setJoayuCount(tmpCount);
        touristAttractionRepository.save(send);
        return send;
    }




}
