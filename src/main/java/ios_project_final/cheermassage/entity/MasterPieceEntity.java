package ios_project_final.cheermassage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
//지친 당신을 위한
@Entity
@Table(name = "masterpiece")
@Getter
@Setter
@RequiredArgsConstructor
public class MasterPieceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "artist")
    private String artist;

    @Column(name = "year_of_creation")
    private Integer yearOfCreation;

    @Column(name = "genre")
    private String genre;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;
    //유저 레이팅
    @Column(name = "joayu_count")
    private Integer joayuCount;
}
