package com.MBR.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.MBR.pojo.*;
import com.MBR.util.HibernateUtils;

@Repository("metaDataDao")
public class InputParameterDao {

	public List<MbrInputParameter> findAllMetaData() {
		Session session = HibernateUtils.getCurrentSession();
		List<MbrInputParameter> list = session.createQuery("from MbrInputParameter").list();
		return list;
	}
	
	public MbrInputParameter getMetaDataById(Integer id){
		Session session = HibernateUtils.getCurrentSession();
		MbrInputParameter metaData = new MbrInputParameter();
		metaData=  (MbrInputParameter) session.get(MbrInputParameter.class, id);
		return metaData;		
	}
}
