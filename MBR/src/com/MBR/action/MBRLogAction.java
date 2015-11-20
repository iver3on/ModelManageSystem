package com.MBR.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MBR.pojo.LogPage;
import com.MBR.pojo.MbrLog;
import com.MBR.service.impl.LogServiceImp;

/**
 * @author Iver3oN Zhang
 * @date 2015-11-2 Impossible is nothing
 */
@Controller
@RequestMapping(value = "log")
public class MBRLogAction {
	// 接口前面标上@Autowired注释使得接口可以被容器注入
	@Autowired
	@Qualifier("logService")
	// 注释指定注入 Bean
	private LogServiceImp logService;
	// 每页展示的日志数目
	private static final int ONE_PAGE_SIZE = 10;

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String query() {
		return "redirect:/log/query/1/page";
	}

	// 查询分页
	@RequestMapping(value = "/query/{index}/page", method = RequestMethod.GET)
	public String logPage(@PathVariable String index, Model model) {
		System.out.println("传入的index：" + index);
		List<MbrLog> list = logService.getAllLogs();
		int i = 0;
		if (index == "") {
			i = 1;
		} else {
			i = Integer.parseInt(index);
		}

		int fromIndex = (i - 1) * ONE_PAGE_SIZE;
		int toIndex = Math.min(fromIndex + ONE_PAGE_SIZE, list.size());

		List<MbrLog> logList = list.subList(fromIndex, toIndex);// 截取list的指定序列的视图
		int sumPage = (list.size() + ONE_PAGE_SIZE - 1) / ONE_PAGE_SIZE; // 页面总数
		LogPage p = new LogPage();// 创建 分页对象
		p.setSearch(false);// 设置未搜索
		p.setIndex(i);// 设置页数
		p.setPageSize(ONE_PAGE_SIZE);
		p.setSum(list.size());// 设置总共的条数
		p.setPageSum(sumPage);// 设置总的页数
		p.setList(logList);// 设置数据
		model.addAttribute("logPage", p);
		System.out.println(p + "444");
		return "/log/logQuery";
	}

	@RequestMapping(value = "/query/{index}/search", method = RequestMethod.POST)
	public String logSearchPage(@PathVariable String index, String searchName,
			String actionId, String timedate, String timedateLate,
			String content, Model model) {
		System.out.println("传入的searchName：" + searchName);
		System.out.println("传入的actionid：" + actionId);
		System.out.println("传入的timedate：" + timedate);
		System.out.println("传入的timedateLate：" + timedateLate);
		System.out.println("传入的content：" + content);
		List<MbrLog> list = new ArrayList<MbrLog>();
		list = logService.findLogByFiveCondition(actionId, searchName,
				timedate, timedateLate, content);
		int i = 0;
		if (index == "") {
			i = 1;
		} else {
			i = Integer.parseInt(index);
		}

		// 按照每页获取不同的list视图
		int fromIndex = (i - 1) * ONE_PAGE_SIZE;
		int toIndex = Math.min(fromIndex + ONE_PAGE_SIZE, list.size());
		List<MbrLog> logList = list.subList(fromIndex, toIndex);
		int sumPage = (list.size() + ONE_PAGE_SIZE - 1) / ONE_PAGE_SIZE; // 页面总数
		LogPage p = new LogPage();// 创建 分页对象

		p.setSearch(true);
		p.setSearchName(searchName);
		p.setIndex(i);// 设置页数
		p.setPageSize(ONE_PAGE_SIZE);
		// 页头显示
		p.setSearchInfo(showInfo(actionId, searchName, timedate, timedateLate,
				content));
		p.setSum(list.size());// 设置总共的条数
		p.setPageSum(sumPage);
		p.setList(logList);// 设置数据
		p.setActionId(actionId);
		p.setStartTime(timedate);
		p.setEndTime(timedateLate);
		p.setContent(content);
		model.addAttribute("logPage", p);
		return "/log/logQuery";
	}

	// 查询列表 头部显示
	public String showInfo(String actionId, String searchName, String timedate,
			String timedateLate, String content) {
		String action = "";
		String search = "";
		String startTime = "";
		String endTime = "";
		String contents = "";
		if (actionId.equals("0")) {
			action = "";
		} else {
			action = getActionName(actionId);
		}
		if (searchName.equals("0")) {
			search = "";
		} else {
			search = searchName;
		}
		if (timedate.equals("0")) {
			startTime = "";
		} else {
			startTime = timedate + "到";
		}
		if (timedateLate.equals("0")) {
			endTime = "";
		} else {
			endTime = timedateLate;
		}
		if (content.equals("0")) {
			contents = "";
		} else {
			contents = "内容：" + content;
		}
		return action + " " + search + " " + startTime + "" + endTime + " "
				+ contents;
	}

	public String getActionName(String action) {
		String s = "";
		if (Integer.parseInt(action) == 201) {
			s = "查看模型";
		} else if (Integer.parseInt(action) == 202) {
			s = "增加模型";
		} else if (Integer.parseInt(action) == 203) {
			s = "修改模型";
		} else if (Integer.parseInt(action) == 204) {
			s = "删除模型";
		} else if (Integer.parseInt(action) == 205) {
			s = "审核模型";
		}
		return s;
	}

	
	//复用RBR
	@RequestMapping(value = "/query/{index}/{searchName}/{actionId}/{timedate}/{timedateLate}/{content}/search", method = RequestMethod.GET)
	public String logSearch(@PathVariable String index,
			@PathVariable String searchName, @PathVariable String actionId,
			@PathVariable String timedate, @PathVariable String timedateLate,
			@PathVariable String content, Model model) {
		System.out.println("logSearch传入的index：" + index);
		System.out.println("logSearch传入的searchName：" + searchName);
		System.out.println("logSearch传入的actionid：" + actionId);
		System.out.println("logSearch传入的timedate：" + timedate);
		System.out.println("logSearch传入的timedateLate：" + timedateLate);
		System.out.println("logSearch传入的content：" + content);
		List<MbrLog> list = new ArrayList<MbrLog>();
		list = logService.findLogByFiveCondition(actionId, searchName,
				timedate, timedateLate, content);
		int i = 0;
		if (index == "") {
			i = 1;
		} else {
			i = Integer.parseInt(index);
		}

		// 按照每页获取不同的list视图
		int fromIndex = (i - 1) * ONE_PAGE_SIZE;
		int toIndex = Math.min(fromIndex + ONE_PAGE_SIZE, list.size());
		List<MbrLog> logList = list.subList(fromIndex, toIndex);
		int sumPage = (list.size() + ONE_PAGE_SIZE - 1) / ONE_PAGE_SIZE; // 页面总数
		LogPage p = new LogPage();// 创建 分页对象

		p.setSearch(true);
		p.setSearchName(searchName);
		p.setIndex(i);// 设置页数
		p.setPageSize(ONE_PAGE_SIZE);
		p.setSearchInfo(showInfo(actionId, searchName, timedate, timedateLate,
				content));
		p.setSum(list.size());// 设置总共的条数
		p.setPageSum(sumPage);
		p.setList(logList);// 设置数据
		p.setActionId(actionId);
		p.setStartTime(timedate);
		p.setEndTime(timedateLate);
		p.setContent(content);
		model.addAttribute("logPage", p);
		return "/log/logQuery";
	}
}
