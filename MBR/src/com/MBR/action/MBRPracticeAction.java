package com.MBR.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MBR.pojo.MbrModelCondition;
import com.MBR.pojo.MbrModels;
import com.MBR.service.LogService;
import com.MBR.service.ModelService;
import com.MBR.service.PracticeService;

/**
 * @author Iver3oN Zhang
 * @date 2015-11-6 Impossible is nothing
 */
@Controller
@RequestMapping("practice")
public class MBRPracticeAction {

	@Autowired
	private ModelService modelService;
	
	@Autowired
	private LogService logService;
	
	@Autowired
	private PracticeService practiceService;

	@RequestMapping(value = "/startPractice", method = RequestMethod.GET)
	public String practicePage(Model model) {
		model.addAttribute("modelList", modelService.getAllModelsByState(1));
		return "reasoning/input";
	}

	@RequestMapping(value = "/{id}/practicePage", method = RequestMethod.GET)
	public String practiceModel(@PathVariable Integer id, Model model) {
		MbrModels models = modelService.getModelById(id);
		Set<MbrModelCondition> set = models.getMbrModelConditions();
		modelService.updateUsedById(id, 1);
		logService.addLog("zwb", models.getName(), new Date(), "401",
				"模型训练");
		model.addAttribute("inputPara", set);
		model.addAttribute("id", id);
		model.addAttribute("inputParaSize", set.size());
		model.addAttribute("model",models);
		return "reasoning/practiceModel";
	}
	
	@RequestMapping(value = "/{id}/practice", method = RequestMethod.POST)
	public String practice(@PathVariable Integer id, Model model, String in1,
			String in2, String in3, String in4, String in5, String in6,
			String in7) {
		Map<Integer, String> paraMap = new HashMap<Integer, String>();
		MbrModels models = modelService.getModelById(id);
		//加入日志
		modelService.updateUsedById(id, 1);
		logService.addLog("zwb", models.getName(), new Date(), "401",
				"模型训练");
		Set<MbrModelCondition> set = models.getMbrModelConditions();
		for (MbrModelCondition mbrModelCondition : set) {
			int paraId = mbrModelCondition.getMbrMetaData().getId();
			if (paraId == 1) {
				paraMap.put(1, in1);
				continue;
			}
			if (paraId == 2) {
				paraMap.put(2, in2);
				continue;
			}
			if (paraId == 3) {
				paraMap.put(3, in3);
				continue;
			}
			if (paraId == 4) {
				paraMap.put(4, in4);
				continue;
			}
			if (paraId == 5) {
				paraMap.put(5, in5);
				continue;
			}
			if (paraId == 6) {
				paraMap.put(6, in6);
				continue;
			}
			if (paraId == 7) {
				paraMap.put(7, in7);
				continue;
			}
		}
		// 调用模型服务 返回起始位置 和长度 在前端展示
		practiceService.startReason(paraMap);
		return "";
	}

}
