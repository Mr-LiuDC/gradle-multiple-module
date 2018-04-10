package cn.alittler.service.write.impl;

import ch.qos.logback.classic.Level;
import cn.alittler.dto.DemoDto;
import cn.alittler.entity.DemoEntity;
import cn.alittler.repository.DemoRepository;
import cn.alittler.service.write.UpdateDemoService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

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
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName(name);
        return (DemoDto) demoRepository.save(demoEntity);
    }

    @Override
    public void deleteDemoById(String id) {
        if (StringUtils.isBlank(id)) {
            demoRepository.delete(Long.parseLong(id));
        }
    }

    @Override
    public DemoDto updateDemoById(Long id, String name, String modifiedTime) {
        DemoDto demoDto = new DemoDto();
        DemoEntity demoEntity = demoRepository.findOne(id);
        demoEntity.setName(name);
        try {
            demoEntity.setCreateTime(DateUtils.parseDate(modifiedTime, "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException e) {
            log.warn("updateDemoById() returned: ", e.getMessage());
        }
        BeanUtils.copyProperties(demoRepository.save(demoEntity), demoDto);
        return demoDto;
    }

}
