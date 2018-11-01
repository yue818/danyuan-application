package org.danyuan.application.crawler.task.controller;

import java.util.List;

import org.danyuan.application.common.base.Pagination;
import org.danyuan.application.crawler.task.po.SysCrawlerUrlInfo;
import org.danyuan.application.crawler.task.service.SysCrawlerUrlInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**    
*  文件名 ： SysCrawlerUrlInfoController.java  
*  包    名 ： org.danyuan.application.crawler.task.controller  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  机能名称：
*  技能ID ：
*  作    者 ： wang  
*  时    间 ： 2018年11月2日 上午6:24:12  
*  版    本 ： V1.0    
*/
@RestController
@RequestMapping("/sysCrawlerUrlInfo")
public class SysCrawlerUrlInfoController {
	
	@Autowired
	SysCrawlerUrlInfoService sysCrawlerUrlInfoService;
	
	/** 
	*  方法名 ： page
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param vo
	*  参    数 ： @return  
	*  参    考 ： @see org.danyuan.application.common.base.BaseController#page(org.danyuan.application.common.base.Pagination)  
	*  作    者 ： wang  
	*/
	@RequestMapping("/page")
	public Page<SysCrawlerUrlInfo> page(@RequestBody Pagination<SysCrawlerUrlInfo> vo) {
		return sysCrawlerUrlInfoService.page(vo.getPageNumber(), vo.getPageSize(), vo.getInfo(), vo.getMap(), new Order(""));
	}
	
	/** 
	*  方法名 ： findAll
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param info
	*  参    数 ： @return  
	*  参    考 ： @see org.danyuan.application.common.base.BaseController#findAll(java.lang.Object)  
	*  作    者 ： wang  
	*/
	@RequestMapping("/findAll")
	public List<SysCrawlerUrlInfo> findAll(@RequestBody SysCrawlerUrlInfo info) {
		return sysCrawlerUrlInfoService.findAll(info);
	}
	
	/** 
	*  方法名 ： findOne
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param info
	*  参    数 ： @return  
	*  参    考 ： @see org.danyuan.application.common.base.BaseController#findOne(java.lang.Object)  
	*  作    者 ： wang  
	*/
	@RequestMapping("/findOne")
	public SysCrawlerUrlInfo findOne(@RequestBody SysCrawlerUrlInfo info) {
		return sysCrawlerUrlInfoService.findOne(info);
	}
	
	/** 
	*  方法名 ： save
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param info
	*  参    数 ： @return  
	*  参    考 ： @see org.danyuan.application.common.base.BaseController#save(java.lang.Object)  
	*  作    者 ： wang  
	*/
	@RequestMapping("/save")
	public String save(@RequestBody SysCrawlerUrlInfo info) {
		sysCrawlerUrlInfoService.save(info);
		return "1";
	}
	
	/** 
	*  方法名 ： save
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param vo
	*  参    数 ： @return  
	*  参    考 ： @see org.danyuan.application.common.base.BaseController#save(org.danyuan.application.common.base.Pagination)  
	*  作    者 ： wang  
	*/
	@RequestMapping("/saveAll")
	public String save(@RequestBody Pagination<SysCrawlerUrlInfo> vo) {
		sysCrawlerUrlInfoService.save(vo.getList());
		return "1";
	}
	
	/** 
	*  方法名 ： delete
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param vo
	*  参    数 ： @return  
	*  参    考 ： @see org.danyuan.application.common.base.BaseController#delete(org.danyuan.application.common.base.Pagination)  
	*  作    者 ： wang  
	*/
	@RequestMapping("/deleteAll")
	public String delete(@RequestBody Pagination<SysCrawlerUrlInfo> vo) {
		sysCrawlerUrlInfoService.delete(vo.getList());
		return "1";
	}
	
	/** 
	*  方法名 ： delete
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param info
	*  参    数 ： @return  
	*  参    考 ： @see org.danyuan.application.common.base.BaseController#delete(java.lang.Object)  
	*  作    者 ： wang  
	*/
	@RequestMapping("/delete")
	public String delete(@RequestBody SysCrawlerUrlInfo info) {
		sysCrawlerUrlInfoService.delete(info);
		return "1";
	}
	
	/** 
	*  方法名 ： trunc
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see org.danyuan.application.common.base.BaseController#trunc()  
	*  作    者 ： wang  
	*/
	@RequestMapping("/trunc")
	public String trunc() {
		sysCrawlerUrlInfoService.trunc();
		return "1";
	}
	
}
