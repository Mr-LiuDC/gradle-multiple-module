package cn.alittler.web.rest;

import cn.alittler.dto.DemoDto;
import cn.alittler.service.read.DemoQueryService;
import cn.alittler.service.write.UpdateDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping
    public DemoDto saveDemo(@Valid @RequestParam String name) {
        DemoDto demoDto = updateDemoService.saveDemo(name);
        log.info("saveDemo() {0}", demoDto.toString());
        return demoDto;
    }

    @GetMapping("{id}")
    public ResponseEntity deleteDemo(@Valid @PathVariable String id) {
        updateDemoService.deleteDemoById(id);
        log.info("deleteDemo() by {0}", id);
        return ResponseEntity.ok("删除成功");
    }

    @PutMapping
    public ResponseEntity updateDemo(@RequestParam String id, @RequestParam String name, @RequestParam String modifiedTime) {
        DemoDto demoDto = updateDemoService.updateDemoById(id, name, modifiedTime);
        log.info("updateDemo() {0}", demoDto);
        return ResponseEntity.ok(demoDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity getDemo(@RequestParam String id) {
        DemoDto demoDto = demoQueryService.getDemoById(id);
        log.info("getDemo() by {0}", id);
        return ResponseEntity.ok(demoDto);
    }

    @GetMapping()
    public ResponseEntity getDemoList(Integer pageNo, Integer pageSize) {
        PageRequest pageable = new PageRequest(pageNo, pageSize);
        Page<DemoDto> demoDtoPage = demoQueryService.getDemoList(pageable);
        log.info("getDemoList() {0}", demoDtoPage);
        return ResponseEntity.ok(demoDtoPage);
    }

}
