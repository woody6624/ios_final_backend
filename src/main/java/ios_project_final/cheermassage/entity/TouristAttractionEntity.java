package ios_project_final.cheermassage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tourist_attraction")
@Getter
@Setter
@RequiredArgsConstructor
public class TouristAttractionEntity {
    @Id
    @Column(name = "seoul_gu")
    private String seoulGu;

    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "joayu_count")
    private Integer joayuCount;
}
