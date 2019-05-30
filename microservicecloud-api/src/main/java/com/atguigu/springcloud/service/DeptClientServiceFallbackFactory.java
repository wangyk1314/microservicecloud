package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Wangyuke on 2019/5/28.
 */

@Component  //不要忘记添加，不要忘记添加，没有这个注解不起作用
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(@PathVariable("id") long id) {
                return new Dept().setDeptno(id).setDname("该id："+id+"没有对应的信息,Consumer客户端提供的降级信息，此刻服务Provider").setDb_source("no this database in mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
