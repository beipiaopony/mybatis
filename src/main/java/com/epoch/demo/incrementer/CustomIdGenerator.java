package com.epoch.demo.incrementer;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

/** 自定义id生成方式，可以定义数据或者字符串
 * @author rogerwang
 * create 2020-03-11 20:30
 * Description:
 */

@Component
public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Number nextId(Object entity) {
        return null;
    }

    @Override
    public String nextUUID(Object entity) {

        //可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
        String bizKey = entity.getClass().getSimpleName();
        return (bizKey + "-" + IdWorker.get32UUID()).substring(0,32);
    }
}
