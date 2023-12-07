package kr.ac.mjc.hotel.repository;

import kr.ac.mjc.hotel.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{

    public User findByName(String name);
    public User findByPhone(String phone);
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);

}
