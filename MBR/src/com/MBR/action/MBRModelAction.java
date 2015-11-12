package com.MBR.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MBR.pojo.MbrModels;
import com.MBR.service.impl.LogServiceImp;
import com.MBR.service.impl.MetaDataServiceImp;
import com.MBR.service.impl.ModelServiceImp;

/**
 * @author Iver3oN Zhang
 * @date 2015-10-30 Impossible is nothing
 */
@Controller
@RequestMapping("model")
public class MBRModelAction {
	// 自动注入
	@Autowired
	private MetaDataServiceImp metaDataService;
	@Autowired
	private ModelServiceImp modelService;
	@Autowired
	private LogServiceImp logService;

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

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("allMetaDatas", metaDataService.getAllMetaData());
		return "/modelManage/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(String leftList, String username, String name) {

		// leftMap
		List<Integer> list = new ArrayList<Integer>();
		String[] tempStringArr = leftList.split(",");
		for (int i = 0; i < tempStringArr.length; i++) {
			list.add(Integer.valueOf(tempStringArr[i]));
		}
		String result = modelService.addModelToExam(list, username, name);
		// 日志 新加模型
		logService.addLog(username, name, new Date(), "202",
				getActionName("202"));
		return result;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model) {
		model.addAttribute("AllModelsList", modelService.getAllModels());
		return "/modelManage/delete";
	}

	@RequestMapping(value = "/{id}/deleteById", method = RequestMethod.GET)
	public String deleteConfirm(@PathVariable Integer id, Model model) {
		MbrModels mbrModel = modelService.getModelById(id);
		model.addAttribute("model", mbrModel); // 将当前节点传到页面
		return "/modelManage/modelDeleteConfirm";
	}

	@RequestMapping(value = "/{id}/deleteConfirm", method = RequestMethod.POST)
	public String deleteConfirm(@PathVariable Integer id) {
		MbrModels mbrModel = modelService.getModelById(id);
		logService.addLog("zwb", mbrModel.getName(), new Date(), "204",
				getActionName("204"));
		modelService.deleteModelById(id);
		return "redirect:/model/delete";
	}

	@RequestMapping(value = "/{id}/sleepConfirm", method = RequestMethod.POST)
	public String sleepConfirm(@PathVariable Integer id) {
		MbrModels mbrModel = modelService.getModelById(id);
		logService.addLog("zwb", mbrModel.getName(), new Date(), "106",
				"模型休眠");
		modelService.sleepModelById(id);
		return "redirect:/model/delete";
	}
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String query(Model model) {
		// 这里的"zwb" 后面可以通过全局session获取 操作的人的姓名。也就是登录的人的姓名
		logService.addLog("zwb", "查询模型", new Date(), "201",
				getActionName("201"));
		model.addAttribute("AllModelsList", modelService.getAllModels());
		return "/modelManage/query";
	}

	@RequestMapping(value = "/change", method = RequestMethod.GET)
	public String change(Model model) {
		model.addAttribute("AllModelsList", modelService.getAllModels());
		return "/modelManage/change";
	}

	@RequestMapping(value = "/{id}/changeDetail", method = RequestMethod.GET)
	public String changeDetail(@PathVariable Integer id, Model model) {
		MbrModels mbrModels = modelService.getModelById(id);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 创建日期格式化
		model.addAttribute("changeTime", dateFormat.format(new Date()));// 将日期传到页面
		model.addAttribute("model", mbrModels);
		model.addAttribute("tag", 0);
		return "/modelManage/modelChange";
	}

	//修改名称成功与否
	@RequestMapping(value = "/{id}/changeName", method = RequestMethod.POST)
	public String changeName(@PathVariable Integer id, String afterChange,Model model) {
		String result = modelService.changeNameById(id, afterChange);
		System.out.println("changeResult is:"+result);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 创建日期格式化
		//修改名称的结果
		MbrModels mbrModels = modelService.getModelById(id);
		model.addAttribute("model", mbrModels);
		model.addAttribute("result", result);
		model.addAttribute("tag", 1);
		model.addAttribute("changeTime",dateFormat.format(new Date()));// 将日期传到页面
		logService.addLog("zwb", mbrModels.getName(), new Date(), "203",
				getActionName("203"));
		return "/modelManage/modelChange";
	}

	@RequestMapping(value = "/exam", method = RequestMethod.GET)
	public String exam(Model model) {
		model.addAttribute("needExamList", modelService.getAllModelsByState(0));
		model.addAttribute("needExamListLength", modelService
				.getAllModelsByState(0).size());
		return "modelManage/exam";
	}

	@RequestMapping(value = "/{id}/examDetail", method = RequestMethod.GET)
	public String examDetail(@PathVariable Integer id, Model model) {
		MbrModels models = modelService.getModelById(id);
		model.addAttribute("model", models);
		// 找出跟此模型具有相同输入条件的模型集合
		model.addAttribute("sameInputParaModelList", modelService
				.getModelsByInput(models.getMbrModelConditions(), 1));
		return "modelManage/examModel";
	}

	@RequestMapping(value = "/{id}/examReject", method = RequestMethod.POST)
	public String examReject(@PathVariable Integer id, Model model) {
		String examName = "Zwb";
		// 未审核通过的模型，需要加上审核员姓名，是通过全局登录Session 传过来的，待跟进
		modelService.updateState(id, examName, 2);
		MbrModels mbrModel = modelService.getModelById(id);
		logService.addLog("zwb", mbrModel.getName(), new Date(), "205",
				getActionName("205"));
		return "redirect:/model/exam";
	}

	@RequestMapping(value = "/{id}/examPass", method = RequestMethod.POST)
	public String examPass(@PathVariable Integer id, Model model) {
		String examName = "Zwb";
		modelService.updateState(id, examName, 1);
		MbrModels mbrModel = modelService.getModelById(id);
		logService.addLog("zwb", mbrModel.getName(), new Date(), "205",
				getActionName("205"));
		return "redirect:/model/exam";
	}
}
