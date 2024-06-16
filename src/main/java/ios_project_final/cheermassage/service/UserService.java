package ios_project_final.cheermassage.service;

import ios_project_final.cheermassage.entity.UserEntity;
import ios_project_final.cheermassage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity registerUser(String kakaoId, String userName, String userPassword, String userAddress) {
        UserEntity newUser = new UserEntity();
        newUser.setKakaoId(kakaoId);
        newUser.setUserName(userName);
        newUser.setUserPassword(userPassword);
        newUser.setUserAddress(userAddress);
        newUser.setDailyVisitCount(0); // Initialize daily visit count

        return userRepository.save(newUser);
    }

    public UserEntity loginUser(String kakaoId, String userPassword) {
        return userRepository.findByKakaoIdAndUserPassword(kakaoId, userPassword);
    }
}
