package com.MBR.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.MBR.pojo.*;
import com.MBR.util.HibernateUtils;

@Repository("metaDataDao")
public class MetaDataDao {

	public List<MbrMetaData> findAllMetaData() {
		Session session = HibernateUtils.getCurrentSession();
		List<MbrMetaData> list = session.createQuery("from MbrMetaData").list();
		return list;
	}
	
	public MbrMetaData getMetaDataById(Integer id){
		Session session = HibernateUtils.getCurrentSession();
		MbrMetaData metaData = new MbrMetaData();
		metaData=  (MbrMetaData) session.get(MbrMetaData.class, id);
		return metaData;		
	}
}
