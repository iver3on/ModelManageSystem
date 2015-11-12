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
import com.MBR.service.ReasonService;

/**
 * @author Iver3oN Zhang
 * @date 2015-11-6 Impossible is nothing
 */
@Controller
@RequestMapping("reason")
public class MBRReasonAction {

	@Autowired
	private ModelService modelService;
	@Autowired
	private ReasonService reasonService;
	@Autowired
	private LogService logService;

	@RequestMapping(value = "/startReason", method = RequestMethod.GET)
	public String reason(Model model) {
		model.addAttribute("modelList", modelService.getAllModelsByState(1));
		return "reasoning/startReason";
	}

	@RequestMapping(value = "/{id}/reasonPage", method = RequestMethod.GET)
	public String reasonPage(@PathVariable Integer id, Model model) {
		MbrModels models = modelService.getModelById(id);
		// 使用过，修改使用过状态
		modelService.updateUsedById(id, 1);
		Set<MbrModelCondition> set = models.getMbrModelConditions();
		model.addAttribute("id", id);
		model.addAttribute("inputPara", set);
		return "reasoning/reason";
	}

	// 推理前 输入参数 执行推理
	@RequestMapping(value = "/{id}/reason", method = RequestMethod.POST)
	public String reasonPage(@PathVariable Integer id, Model model, String in1,
			String in2, String in3, String in4, String in5, String in6,
			String in7) {
		Map<Integer, String> paraMap = new HashMap<Integer, String>();
		MbrModels models = modelService.getModelById(id);
		//加入日志
		logService.addLog("zwb", models.getName(), new Date(), "301",
				"模型推理");
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
		reasonService.startReason(paraMap);
		return "";
	}
}
