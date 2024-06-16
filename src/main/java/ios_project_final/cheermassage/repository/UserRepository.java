package ios_project_final.cheermassage.repository;

import ios_project_final.cheermassage.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity,String> {
    @Query("SELECT u FROM UserEntity u WHERE u.kakaoId = :kakaoId AND u.userPassword = :userPassword")
    UserEntity findByKakaoIdAndUserPassword(@Param("kakaoId") String kakaoId, @Param("userPassword") String userPassword);

}
