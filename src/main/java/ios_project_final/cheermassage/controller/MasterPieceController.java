package ios_project_final.cheermassage.controller;

import ios_project_final.cheermassage.entity.MasterPieceEntity;
import ios_project_final.cheermassage.service.MasterPieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/masterpieces")

public class MasterPieceController {
    private final MasterPieceService masterpieceService;

    @Autowired
    public MasterPieceController(MasterPieceService masterpieceService) {
        this.masterpieceService = masterpieceService;
    }

    @GetMapping("/random")
    public MasterPieceEntity getRandomMasterpiece() {
        return masterpieceService.getRandomMasterpiece();
    }

    @PostMapping("/{masterpieceId}/like")
    public void likeMasterpiece(@PathVariable Long masterpieceId) {
        masterpieceService.updateJoayuCount(masterpieceId);
    }
}
