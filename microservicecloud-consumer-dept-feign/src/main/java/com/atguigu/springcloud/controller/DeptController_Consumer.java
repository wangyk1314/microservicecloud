package com.atguigu.springcloud.controller;

import java.util.List;

import com.atguigu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {
	@Autowired
	private DeptClientService deptClientService;

	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept)
	{
		return deptClientService.add(dept);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return deptClientService.get(id);
	}

	@SuppressWarnings("unchecked") //去警告用
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list()
	{
		return deptClientService.list();
	}
}
