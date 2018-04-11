package cn.alittler.repository;

import cn.alittler.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DemoRepository
 *
 * @author LiuDeCai
 * @date 2018/04/10
 */
public interface DemoRepository extends JpaRepository<DemoEntity, Long> {

}
