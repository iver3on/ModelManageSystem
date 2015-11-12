package com.MBR.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.MBR.service.PracticeService;

@Service("practiceService")
public class PracticeServiceImp implements PracticeService {

	@Override
	public void startReason(Map<Integer, String> paraMap) {
		for (Map.Entry<Integer, String> entrySet : paraMap.entrySet()) {
			System.out.println("训练参数获取-----------");
			System.out.println(entrySet.getKey() + "..." + entrySet.getValue());
		}
	}

}
