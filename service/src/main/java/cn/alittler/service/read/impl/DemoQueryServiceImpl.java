package cn.alittler.service.read.impl;

import cn.alittler.dto.DemoDto;
import cn.alittler.entity.DemoEntity;
import cn.alittler.repository.DemoRepository;
import cn.alittler.service.read.DemoQueryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * DemoQueryServiceImpl
 *
 * @author LiuDeCai
 * @date 2018/04/10
 */
public class DemoQueryServiceImpl implements DemoQueryService {

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public DemoDto getDemoById(Long id) {
        DemoEntity demoEntity = demoRepository.getOne(id);
        DemoDto demoDto = new DemoDto();
        BeanUtils.copyProperties(demoEntity, demoDto);
        return demoDto;
    }

    @Override
    public Page<DemoEntity> getDemoList(Pageable pageable) {
        Page<DemoEntity> demoEntityPage = demoRepository.findAll(pageable);
        List<DemoEntity> demoEntityList = demoEntityPage.getContent();
        PageImpl<DemoEntity> demoDtoPage = new PageImpl<>(demoEntityList);
        return demoDtoPage;
    }
}
