package ios_project_final.cheermassage.repository;

import ios_project_final.cheermassage.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,String> {
    UserEntity findByKakaoIdAndUserPassword(String kakaoId, String userPassword);

}
