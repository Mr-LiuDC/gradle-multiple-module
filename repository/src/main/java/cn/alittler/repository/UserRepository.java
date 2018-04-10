package cn.alittler.repository;

import cn.alittler.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * @author LiuDeCai
 * @date 2018/03/29
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
