package cn.alittler.service.read;

import cn.alittler.dto.DemoDto;
import cn.alittler.entity.DemoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * DemoQueryService
 *
 * @author LiuDeCai
 * @date 2018/04/10
 */
public interface DemoQueryService {

    /**
     * 根据ID查询对象
     *
     * @param id
     * @return
     */
    DemoDto getDemoById(Long id);

    /**
     * 分页查询对象列表
     *
     * @param pageable
     * @return
     */
    Page<DemoDto> getDemoList(Pageable pageable);
}
