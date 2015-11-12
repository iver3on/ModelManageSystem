package com.MBR.service;

import java.util.List;
import java.util.Set;

import com.MBR.pojo.MbrModelCondition;
import com.MBR.pojo.MbrModels;

public interface ModelService {
	String addModelToExam(List<Integer> list, String username, String name);

	List<MbrModels> getAllModels();

	void deleteModelById(Integer id);

	MbrModels getModelById(Integer id);

	String changeNameById(Integer id, String name);

	List<MbrModels> getAllModelsByState(Integer i);

	List<MbrModels> getModelsByInput(Set<MbrModelCondition> mbrModelConditions,
			int state);

	void updateState(Integer id, String examName, Integer i);

	void updateUsedById(Integer id, int i);
}
