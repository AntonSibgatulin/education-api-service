package jp.antonsibgatulin.educationapiservice.repository;

import jp.antonsibgatulin.educationapiservice.entity.home_task.HomeTask;
import jp.antonsibgatulin.educationapiservice.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeTaskRepository extends JpaRepository<HomeTask,Long> {
    List<HomeTask> findAllByUser(User user);
}
