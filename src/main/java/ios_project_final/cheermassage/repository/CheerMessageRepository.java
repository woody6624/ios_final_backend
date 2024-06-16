package ios_project_final.cheermassage.repository;

import ios_project_final.cheermassage.entity.CheerMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CheerMessageRepository extends JpaRepository<CheerMessageEntity,Long> {
    @Query("SELECT c FROM CheerMessageEntity c WHERE c.messageAddress = :userAddress")
    List<CheerMessageEntity> findByMessageAddress(String userAddress);
}
