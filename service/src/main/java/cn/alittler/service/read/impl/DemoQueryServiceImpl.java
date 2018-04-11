package cn.alittler.service.read.impl;

import cn.alittler.dto.DemoDto;
import cn.alittler.entity.DemoEntity;
import cn.alittler.repository.DemoRepository;
import cn.alittler.service.read.DemoQueryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * DemoQueryServiceImpl
 *
 * @author LiuDeCai
 * @date 2018/04/10
 */
@Service
public class DemoQueryServiceImpl implements DemoQueryService {

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public DemoDto getDemoById(String id) {
        DemoDto demoDto = new DemoDto();
        if (!StringUtils.isBlank(id)) {
            DemoEntity demoEntity = demoRepository.getOne(Long.parseLong(id));
            BeanUtils.copyProperties(demoEntity, demoDto);
        }
        return demoDto;
    }

    @Override
    public Page<DemoDto> getDemoList(Pageable pageable) {
        Page<DemoEntity> demoEntityPage = demoRepository.findAll(pageable);
        Page<DemoDto> demoDtoPage = demoEntityPage.map(new Converter<DemoEntity, DemoDto>() {
            @Override
            public DemoDto convert(DemoEntity source) {
                DemoDto demoDto = new DemoDto();
                BeanUtils.copyProperties(source, demoDto);
                return demoDto;
            }
        });
        return demoDtoPage;
    }
}
