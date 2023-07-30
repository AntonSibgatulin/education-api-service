package jp.antonsibgatulin.educationapiservice.repository;

import jp.antonsibgatulin.educationapiservice.entity.access.Access;
import jp.antonsibgatulin.educationapiservice.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessRepository extends JpaRepository<Access, Long> {
    List<Access> findAllByUser(User user);
}
