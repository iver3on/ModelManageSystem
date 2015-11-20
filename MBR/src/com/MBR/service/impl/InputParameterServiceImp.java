package com.MBR.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MBR.dao.InputParameterDao;
import com.MBR.pojo.MbrInputParameter;
import com.MBR.service.InputParameterService;

/**
 * @author Iver3oN Zhang
 * @date 2015-11-9 Impossible is nothing
 */
@Service("inputParameterService")
public class InputParameterServiceImp implements InputParameterService {
	@Autowired
	private InputParameterDao inputParameterDao;

	@Override
	public List<MbrInputParameter> getAllMetaData() {
		List<MbrInputParameter> mbrInputParameters = new ArrayList<MbrInputParameter>();
		mbrInputParameters = inputParameterDao.findAllMetaData();
		return mbrInputParameters;
	}

}
