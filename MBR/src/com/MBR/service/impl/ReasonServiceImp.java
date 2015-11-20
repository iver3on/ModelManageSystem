package com.MBR.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.MBR.service.ReasonService;

/**
 * @author Iver3oN Zhang
 * @date 2015-11-9 Impossible is nothing
 */
@Service("resonService")
public class ReasonServiceImp implements ReasonService {

	// 开始推理的逻辑
	@Override
	public List<String> startReason(Map<Integer, String> paraMap) {
		List<String> para = new ArrayList<String>();
		
		for (Map.Entry<Integer, String> entrySet : paraMap.entrySet()) {
			System.out.println("推理参数获取-----------");
			System.out.println(entrySet.getKey() + "..." + entrySet.getValue());			
		}
		List<String> x = doReasonFirstStep(paraMap);	
		return x;
	}
	
	public List<String> doReasonFirstStep(Map<Integer, String> paraMap){
		List<String> result = new ArrayList<String>();
		int size = paraMap.size();
		switch (size) {
		case 1:
			result = reasonOnePara(paraMap);
			break;
		case 2:
			result = reasonTwoPara(paraMap);
			break;
		default:
			break;
		}
		return result;
}

	private List<String> reasonTwoPara(Map<Integer, String> paraMap) {
		
		return null;
	}

	private List<String> reasonOnePara(Map<Integer, String> paraMap) {
		List<String> result = new ArrayList<String>();
		if (paraMap.get(1)!=null) {
			result.add(0, "2009");
			result.add(1, "1437");
		}
		return result;
	}
	
}
