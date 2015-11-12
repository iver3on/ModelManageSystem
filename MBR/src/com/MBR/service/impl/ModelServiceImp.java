package com.MBR.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MBR.dao.MetaDataDao;
import com.MBR.dao.ModelsDao;
import com.MBR.pojo.MbrMetaData;
import com.MBR.pojo.MbrModelCondition;
import com.MBR.pojo.MbrModels;
import com.MBR.service.ModelService;

/**
 * @author Iver3oN Zhang
 * @date 2015-10-30 Impossible is nothing
 */
@Service("modelService")
public class ModelServiceImp implements ModelService {
	// RBR定义的状态
	static final int PENDING = 0; // 待审核状态
	static final int PASSED = 1; // 通过审核
	static final int NOTPASS = 2; // 未通过审核

	@Autowired
	private ModelsDao modelDao;
	@Autowired
	private MetaDataDao metaDataDao;

	public String addModelToExam(List<Integer> list, String username, String name) {
		String result="";
		List<MbrMetaData> metaDataList = new ArrayList<MbrMetaData>();
		for(Integer i:list){
			System.out.println(i+"rrrrrrrrrrrrr");
			metaDataList.add(metaDataDao.getMetaDataById(i));
		}
		List<MbrModels> modelsWithSameInput = getModelsByInput(metaDataList, 1);
		List<MbrModels> modelsWithSameName = getModelsByName(name);
		int modelsWithSameInputSize = modelsWithSameInput.size();
		int modelsWithSameNameSize = modelsWithSameName.size();
		//么有重复的输入条件的模型
		System.out.println(modelsWithSameInput.size()+"fff"+modelsWithSameNameSize);
		if(modelsWithSameInputSize==0&&modelsWithSameNameSize==0){
			MbrModels model = new MbrModels();
			model.setUserName(username);
			model.setName(name);
			// 管理员，后面需要修改
			model.setManagerName("zwb");
			// 未使用过
			model.setUsed(0);
			// 时间
			Timestamp nousedate = new Timestamp(new Date().getTime());
			model.setCreateTime(nousedate);
			// 待审核  没有审核这一限制
			model.setState(ModelServiceImp.PASSED);
			modelDao = new ModelsDao();
			modelDao.save(model, list);
			result = "OK";
		}else if(modelsWithSameInputSize!=0&&modelsWithSameNameSize!=0){
			result = "SAME_INPUT_AND_NAME";
		}else if(modelsWithSameInputSize!=0){
			result = "SAME_INPUT";
		}else if(modelsWithSameNameSize!=0){
			result = "SAME_NAME";
		}
		return result;
	}

	private List<MbrModels> getModelsByName(String name) {
		List<MbrModels> list = new ArrayList<MbrModels>();
		list = modelDao.findAllModelsByName(name);
		return list;
	}

	public List<MbrModels> getAllModels() {
		List<MbrModels> list = new ArrayList<MbrModels>();
		list = modelDao.findAllModels();
		return list;
	}

	public void deleteModelById(Integer id) {
		modelDao.delete(id);
	}

	public MbrModels getModelById(Integer id) {
		MbrModels model = modelDao.get(id);
		return model;
	}

	public String changeNameById(Integer id, String name) {
		String result="";
		List<MbrModels> models = modelDao.findAllModelsByName(name);
		if (models.size()==0) {
			modelDao.changeNameById(id, name);
			result="OK";
		}else{
			result="FAIL";
		}
		return result;
	}

	public List<MbrModels> getAllModelsByState(Integer i) {
		List<MbrModels> models = modelDao.findAllModelsByState(i);
		return models;
	}

	// 审核是否有重复的输入条件的模型
	public List<MbrModels> getModelsByInput(
			List<MbrMetaData> list, int state) {
		List<MbrModels> rList = new ArrayList<MbrModels>();
		// 在已审核通过的模型中进行 对比，跟待审核模型具有相同的输入参数的模型将被找出
		for (MbrModels mbrModel : modelDao.findAllModelsByState(state)) {
			Set<Integer> rIdSet = new HashSet<Integer>();
			Set<Integer> sIdSet = new HashSet<Integer>();
			for (MbrModelCondition modelCondition : mbrModel
					.getMbrModelConditions()) {
				rIdSet.add(modelCondition.getMbrMetaData().getId());
			}
//			for (MbrModelCondition condition : mbrModelConditions) {
//				sIdSet.add(condition.getMbrMetaData().getId());
//			}
			for(MbrMetaData metaData:list){
				sIdSet.add(metaData.getId());
			}
			if (rIdSet.containsAll(sIdSet) && sIdSet.containsAll(rIdSet)) {
				rList.add(mbrModel);
			}
		}
		return rList;
	}

	public void updateState(Integer id, String examName, Integer i) {
		modelDao.updateStateById(id, examName, i);
	}

	public void updateUsedById(Integer id, int i) {
		modelDao.updateUsed(id, i);
	}

	public void sleepModelById(Integer id) {
		modelDao.sleepModel(id);
		
	}

	@Override
	public List<MbrModels> getModelsByInput(
			Set<MbrModelCondition> mbrModelConditions, int state) {
		// TODO Auto-generated method stub
		return null;
	}
}
