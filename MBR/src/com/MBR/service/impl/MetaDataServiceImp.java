package com.MBR.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MBR.dao.MetaDataDao;
import com.MBR.pojo.MbrMetaData;
import com.MBR.service.MetaDataService;

/**
 * @author Iver3oN Zhang
 * @date 2015-11-9 Impossible is nothing
 */
@Service("metaDataService")
public class MetaDataServiceImp implements MetaDataService {
	@Autowired
	private MetaDataDao metaDataDao;

	@Override
	public List<MbrMetaData> getAllMetaData() {
		List<MbrMetaData> mbrMetaDatas = new ArrayList<MbrMetaData>();
		mbrMetaDatas = metaDataDao.findAllMetaData();
		return mbrMetaDatas;
	}

}
