package com.MBR.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.MBR.pojo.MbrInputParameter;
import com.MBR.pojo.MbrModelCondition;
import com.MBR.pojo.MbrModels;
import com.MBR.util.HibernateUtils;

/**
 * @author Iver3oN Zhang
 * @date 2015-10-30 Impossible is nothing
 */
@Repository("modelDao")
public class ModelsDao {

	public void save(MbrModels model, List<Integer> leftList) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(model);

		for (Integer temp : leftList) {
			MbrModelCondition condition = new MbrModelCondition();
			MbrInputParameter metaData = (MbrInputParameter) session.load(
					MbrInputParameter.class, temp);
			condition.setMbrMetaData(metaData);
			condition.setMbrModels(model);
			session.save(condition);
		}
	}

	public List<MbrModels> findAllModels() {
		Session session = HibernateUtils.getCurrentSession();
		List<MbrModels> list = session.createQuery("from MbrModels").list();
		return list;
	}

	public void delete(Integer id) {
		Session session = HibernateUtils.getCurrentSession();
		MbrModels model = (MbrModels) session.get(MbrModels.class, id);
		session.delete(model);
	}

	public MbrModels get(Integer id) {
		Session session = HibernateUtils.getCurrentSession();
		MbrModels model = (MbrModels) session.get(MbrModels.class, id);
		return model;
	}

	public void changeNameById(Integer id, String name) {
		Session session = HibernateUtils.getCurrentSession();
		MbrModels model = (MbrModels) session.get(MbrModels.class, id);
		model.setName(name);
	}

	public List<MbrModels> findAllModelsByState(Integer i) {
		Session session = HibernateUtils.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<MbrModels> list = session.createQuery(
				"From MbrModels r Where r.state = " + i).list();
		return list;
	}

	public void updateStateById(Integer id, String examName, Integer i) {
		Session session = HibernateUtils.getCurrentSession();
		MbrModels model = (MbrModels) session.get(MbrModels.class, id);
		model.setManagerName(examName);
		model.setUsed(i);
	}

	public void updateUsed(Integer id, int i) {
		Session session = HibernateUtils.getCurrentSession();
		MbrModels model = (MbrModels) session.get(MbrModels.class, id);
		model.setUsed(i);
	}

	public void sleepModel(Integer id) {
		Session session = HibernateUtils.getCurrentSession();
		MbrModels model = (MbrModels) session.get(MbrModels.class, id);
		//设置已休眠3
		//0是待审核 1是已审核 2是审核不通过
		model.setUsed(3);
	}

	public List<MbrModels> findAllModelsByName(String name) {
		Session session = HibernateUtils.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<MbrModels> list = session.createQuery(
				"From MbrModels r Where r.name like :name").setParameter("name",name).list();
		return list;
	}

}
