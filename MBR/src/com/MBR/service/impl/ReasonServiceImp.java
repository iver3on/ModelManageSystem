package com.MBR.service.impl;

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
	public void startReason(Map<Integer, String> paraMap) {
		for (Map.Entry<Integer, String> entrySet : paraMap.entrySet()) {
			System.out.println("推理参数获取-----------");
			System.out.println(entrySet.getKey() + "..." + entrySet.getValue());
		}
	}
}
