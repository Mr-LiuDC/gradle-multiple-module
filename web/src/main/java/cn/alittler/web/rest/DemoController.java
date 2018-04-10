package cn.alittler.web.rest;

import cn.alittler.dto.DemoDto;
import cn.alittler.service.read.DemoQueryService;
import cn.alittler.service.read.impl.DemoQueryServiceImpl;
import cn.alittler.service.write.UpdateDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController
 *
 * @author LiuDeCai
 * @date 2018/4/11.
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoQueryService demoQueryService;
    @Autowired
    private UpdateDemoService updateDemoService;

    public DemoDto saveDemo(String name) {
        return updateDemoService.saveDemo(name);
    }

    public ResponseEntity deleteDemo(String id) {
        updateDemoService.deleteDemoById(id);
        return ResponseEntity.ok("删除成功");
    }


}
