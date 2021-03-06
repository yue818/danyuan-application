package org.danyuan.application.dbms.tabs.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.danyuan.application.dbms.tabs.po.SysDbmsTabsJdbcInfo;
import org.danyuan.application.dbms.tabs.service.SysDbmsTabsJdbcInfoService;
import org.danyuan.application.dbms.tabs.vo.SysDbmsTabsJdbcInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 文件名 ： SysDbmsTabsJdbcInfoController.java
 * 包 名 ： tk.ainiyue.danyuan.application.dbm.addr.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年8月3日 下午3:46:35
 * 版 本 ： V1.0
 */
@RestController
@RequestMapping("/sysDbmsTabsJdbcInfo")
public class SysDbmsTabsJdbcInfoController {
	//
	private static final Logger			logger	= LoggerFactory.getLogger(SysDbmsTabsJdbcInfoController.class);
	
	@Autowired
	private SysDbmsTabsJdbcInfoService	sysDbmsTabsJdbcInfoService;
	
	/**
	 * 方法名： findAll
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @return
	 * 返 回： List<SysSeedInfo>
	 * 作 者 ： Tenghui.Wang
	 * @throws
	 */
	@RequestMapping(path = "/findAll", method = { RequestMethod.GET, RequestMethod.POST })
	public List<SysDbmsTabsJdbcInfo> findAll() {
		logger.info("findAll", SysDbmsTabsJdbcInfoController.class);
		return sysDbmsTabsJdbcInfoService.findAll();
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String save(@RequestBody SysDbmsTabsJdbcInfo sysDbmsTabsJdbcInfo) {
		logger.info("findAll", SysDbmsTabsJdbcInfoController.class);
		if (sysDbmsTabsJdbcInfo.getUuid() == null || "".equals(sysDbmsTabsJdbcInfo.getUuid())) {
			sysDbmsTabsJdbcInfo.setUuid(UUID.randomUUID().toString());
		}
		sysDbmsTabsJdbcInfoService.save(sysDbmsTabsJdbcInfo);
		return "1";
	}
	
	@RequestMapping(path = "/addBefor", method = RequestMethod.GET)
	public ModelAndView addBefor(HttpServletRequest request) {
		SysDbmsTabsJdbcInfo info = new SysDbmsTabsJdbcInfo();
		if (request.getParameter("uuid") != null && !"".equals(request.getParameter("uuid"))) {
			info.setUuid(request.getParameter("uuid"));
			info = sysDbmsTabsJdbcInfoService.findOne(info);
		}
		logger.info("addBefor", SysDbmsTabsJdbcInfoController.class);
		ModelAndView view = new ModelAndView("dbms/addr/add_addr");
		view.addObject("SysDbmsTabsJdbcInfo", info);
		return view;
	}
	
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String delete(@RequestBody SysDbmsTabsJdbcInfoVo vo) {
		logger.error(vo.getList().get(0).toString());
		logger.info("delete", SysDbmsTabsJdbcInfoController.class);
		sysDbmsTabsJdbcInfoService.deleteAll(vo.getList());
		return "1";
	}
	
}
