package com.findmyfriends.alpha.repository;

        import com.findmyfriends.alpha.domain.User;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.Set;

public interface UserRepository extends JpaRepository<User, String> {

    Set<User> getAll();
}
