package ios_project_final.cheermassage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@RequiredArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "kakao_id")
    private String kakaoId;


    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    //유저 주소
    @Column(name= "user_address")
    private String userAddress;

    //하루에 얼마나 접속했는지
    @Column(name = "daily_visit_count")
    private Integer dailyVisitCount;

}
