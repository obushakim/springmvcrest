package obus.test.springmvcrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import obus.test.springmvcrest.dao.ObusDao;
import obus.test.springmvcrest.model.Obus;

@Transactional(readOnly = true)
@Service("obusService")
public class ObusService {

	@Autowired
	@Qualifier("obusDao")
	private ObusDao obusDao;

	public List<Obus> getObuses() {
		return obusDao.getObusData();
	}
}
