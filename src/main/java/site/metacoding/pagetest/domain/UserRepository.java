package site.metacoding.pagetest.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Usertbl, Integer> {
    @Query(value = "SELECT * FROM user WHERE username = :username AND password = :password", nativeQuery = true)
    Usertbl mLogin(@Param("username") String username, @Param("password") String password);

    boolean existsByusername(String username);
}