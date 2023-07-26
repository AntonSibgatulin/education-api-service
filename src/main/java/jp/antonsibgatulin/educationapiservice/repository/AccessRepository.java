package jp.antonsibgatulin.educationapiservice.repository;

import jp.antonsibgatulin.educationapiservice.entity.access.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<Access, Long> {

}
