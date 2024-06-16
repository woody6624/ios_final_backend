package ios_project_final.cheermassage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "cheer_message")
@Getter
@Setter
@RequiredArgsConstructor
public class CheerMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 치어 메시지 내용
    @Column(name = "message_content")
    private String messageContent;
    //메시지가 어느 지역에서 작성되었는지 -> 유저 엔티티에서와의 비교로 가져온다.
    @Column(name = "message_address")
    private String messageAddress;
    // 유저와의 관계 설정
    @ManyToOne
    @JoinColumn(name = "kakao_id", referencedColumnName = "kakao_id")
    private UserEntity user;

    //헤당 메시지를 사람들이 얼마나 좋아하는지
    @Column(name = "ddabong_count")
    private Integer ddabongCount;

    @Column(name = "message_date")
    private LocalDateTime messageDate;

}
