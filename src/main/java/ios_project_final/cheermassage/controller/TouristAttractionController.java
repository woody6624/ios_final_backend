package ios_project_final.cheermassage.controller;

import ios_project_final.cheermassage.entity.TouristAttractionEntity;
import ios_project_final.cheermassage.service.TouristAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/touristattraction")
public class TouristAttractionController {
    @Autowired
    TouristAttractionService touristAttractionService;
    @GetMapping("/get-gu-tourist")
    public TouristAttractionEntity getTouristAttraction(@RequestParam String seoul_gu){
        return touristAttractionService.getTourist(seoul_gu);
    }

}
