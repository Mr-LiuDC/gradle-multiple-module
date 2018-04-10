package cn.alittler.service.write.impl;

import cn.alittler.dto.DemoDto;
import cn.alittler.entity.DemoEntity;
import cn.alittler.repository.DemoRepository;
import cn.alittler.service.write.UpdateDemoService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * UpdateDemoServiceImpl
 *
 * @author LiuDeCai
 * @date 2018/04/10
 */
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
    public void deleteDemoById(Long id) {
        demoRepository.delete(id);
    }

    @Override
    public DemoDto updateDemoById(Long id, String name, String modifiedTime) {
        DemoEntity demoEntity = demoRepository.findOne(id);
        demoEntity.setName(name);
        try {
            demoEntity.setCreateTime(DateUtils.parseDate(modifiedTime, "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (DemoDto) demoRepository.save(demoEntity);
    }
}
