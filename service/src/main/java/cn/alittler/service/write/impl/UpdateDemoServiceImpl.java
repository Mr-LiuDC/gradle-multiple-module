package cn.alittler.service.write.impl;

import cn.alittler.dto.DemoDto;
import cn.alittler.entity.DemoEntity;
import cn.alittler.repository.DemoRepository;
import cn.alittler.service.write.UpdateDemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

/**
 * UpdateDemoServiceImpl
 *
 * @author LiuDeCai
 * @date 2018/04/10
 */
@Slf4j
@Service
public class UpdateDemoServiceImpl implements UpdateDemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public DemoDto saveDemo(String name) {
        DemoDto demoDto = new DemoDto();
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName(name);
        demoEntity.setCreateTime(new Date());
        demoEntity.setModifiedTime(new Date());
        demoRepository.save(demoEntity);
        BeanUtils.copyProperties(demoEntity, demoDto);
        return demoDto;
    }

    @Override
    public void deleteDemoById(String id) {
        if (!StringUtils.isBlank(id)) {
            demoRepository.delete(Long.parseLong(id));
        }
    }

    @Override
    public DemoDto updateDemoById(String id, String name, String modifiedTime) {
        DemoDto demoDto = new DemoDto();
        if (!StringUtils.isBlank(id)) {
            DemoEntity demoEntity = demoRepository.findOne(Long.parseLong(id));
            demoEntity.setName(name);
            try {
                demoEntity.setCreateTime(DateUtils.parseDate(modifiedTime, "yyyy-MM-dd HH:mm:ss"));
            } catch (ParseException e) {
                log.warn("updateDemoById() returned: ", e.getMessage());
            }
            demoRepository.save(demoEntity);
            BeanUtils.copyProperties(demoRepository.save(demoEntity), demoDto);
            return demoDto;
        }
        return demoDto;
    }

}
