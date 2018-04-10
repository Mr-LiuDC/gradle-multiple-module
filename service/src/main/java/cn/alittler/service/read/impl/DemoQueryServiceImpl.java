package cn.alittler.service.read.impl;

import cn.alittler.dto.DemoDto;
import cn.alittler.entity.DemoEntity;
import cn.alittler.repository.DemoRepository;
import cn.alittler.service.read.DemoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO
 *
 * @author LiuDeCai
 * @date 2018/04/10
 */
public class DemoQueryServiceImpl implements DemoQueryService {

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public DemoDto getDemoById(Long id) {
        return (DemoDto) demoRepository.findOne(id);
    }

    @Override
    public Page<DemoEntity> getDemoList(Pageable pageable) {
        return demoRepository.findAll(pageable);
    }
}
