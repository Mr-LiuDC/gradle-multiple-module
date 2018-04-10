package cn.alittler.service.write;

import cn.alittler.dto.DemoDto;

/**
 * UpdateDemoService
 *
 * @author LiuDeCai
 * @date 2018/04/10
 */
public interface UpdateDemoService {

    /**
     * 保存对象
     *
     * @param name
     * @return
     */
    DemoDto saveDemo(String name);

    /**
     * 根据ID删除对象
     *
     * @param id
     * @return
     */
    void deleteDemoById(Long id);

    /**
     * 根据ID更新对象
     *
     * @param id
     * @param name
     * @param modifiedTime
     * @return
     */
    DemoDto updateDemoById(Long id, String name, String modifiedTime);
}
