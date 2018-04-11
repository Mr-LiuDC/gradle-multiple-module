package cn.alittler.repository;

import cn.alittler.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DemoRepository
 *
 * @author LiuDeCai
 * @date 2018/04/10
 */
@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Long> {

}
