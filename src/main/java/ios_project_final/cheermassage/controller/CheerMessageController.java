package ios_project_final.cheermassage.controller;

import ios_project_final.cheermassage.entity.CheerMessageEntity;
import ios_project_final.cheermassage.service.CheerMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cheer-messages")
public class CheerMessageController {

    private final CheerMessageService cheerMessageService;

    @Autowired
    public CheerMessageController(CheerMessageService cheerMessageService) {
        this.cheerMessageService = cheerMessageService;
    }


    //같은 동에 사는 사람들 메시지 보여줌
    @GetMapping("/find-messages")
    public List<CheerMessageEntity> findMessagesBySameDong(@RequestParam("user_address") String userAddress){
        List<CheerMessageEntity> cheerMessageEntities= cheerMessageService.see(userAddress);
        return cheerMessageEntities;
    }

    @PostMapping("/register")
    public void registerNewCheerMessage(@RequestParam("kakao_id") String kakaoId,
                                        @RequestParam("message_content") String messageContent) {
        cheerMessageService.registerNewCheerMessage(kakaoId, messageContent);
    }

    @PutMapping("/update-ddabong")
    public void updateDdabongCount(@RequestParam("message_id") Long messageId) {
        cheerMessageService.updateDdabongCount(messageId);
    }
}