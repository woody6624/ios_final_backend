package ios_project_final.cheermassage.controller;

import ios_project_final.cheermassage.entity.TouristAttractionEntity;
import ios_project_final.cheermassage.service.TouristAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/touristattraction")
public class TouristAttractionController {
    @Autowired
    TouristAttractionService touristAttractionService;
    @GetMapping("/get-gu-tourist")
    public TouristAttractionEntity getTouristAttraction(@RequestParam String seoul_gu){
        return touristAttractionService.getTourist(seoul_gu);
    }

    @PostMapping("/increase-joayo")
    public TouristAttractionEntity increaseJoayuCount(@RequestParam String seoul_gu){
        return touristAttractionService.increaseJoayuCount(seoul_gu);
    }

}
