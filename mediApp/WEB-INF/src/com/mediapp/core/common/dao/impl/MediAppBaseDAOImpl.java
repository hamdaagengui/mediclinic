package com.mediapp.core.common.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class MediAppBaseDAOImpl extends SqlMapClientDaoSupport{

	public MediAppBaseDAOImpl() {
	}
	protected final Log logger = LogFactory.getLog(getClass());
	/**
	 * Returns single Object
	 * @param operationName
	 * @param criteria
	 * @return
	 */
	public Object getObject(String operationName, Map criteria) {
		Object obj = null;
		try {
			obj = getSqlMapClient().queryForObject(operationName,
					criteria);
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder()).append("Object retrieved [")
						.append(obj).append("]").toString());
		} catch (SQLException se) {
			org.springframework.dao.DataAccessException dae = super
					.getSqlMapClientTemplate().getExceptionTranslator()
					.translate("RetrieveObject", operationName, se);
			throw dae;
		}
		return obj;
	}
	
	public Object getList(String operationName, Map criteria) {
		Object obj = null;
		try {
			obj = getSqlMapClient().queryForList(operationName,
					criteria);
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder()).append("Object retrieved [")
						.append(obj).append("]").toString());
		} catch (SQLException se) {
			org.springframework.dao.DataAccessException dae = super
					.getSqlMapClientTemplate().getExceptionTranslator()
					.translate("RetrieveObject", operationName, se);
			throw dae;
		}
		return obj;
	}

	public Object getListNoOptions(String operationName) {
		Object obj = null;
		try {
			obj = getSqlMapClient().queryForList(operationName);
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder()).append("Object retrieved [")
						.append(obj).append("]").toString());
		} catch (SQLException se) {
			org.springframework.dao.DataAccessException dae = super
					.getSqlMapClientTemplate().getExceptionTranslator()
					.translate("RetrieveObject", operationName, se);
			throw dae;
		}
		return obj;
	}

	
	public boolean insertObject(String operationName, Object insertObject) {
		Object obj = null;
		try {
			
			obj = getSqlMapClient().insert(operationName,
					insertObject);
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder()).append("Object inserted [")
						.append(obj).append("]").toString());
		} catch (SQLException se) {
			org.springframework.dao.DataAccessException dae = super
					.getSqlMapClientTemplate().getExceptionTranslator()
					.translate("RetrieveObject", operationName, se);
			throw dae;
		}
		boolean success=true;
		return success;
	}

	public Object updateObject(String operationName, Map criteria) {
		Object obj = null;
		try {
			
			obj = getSqlMapClient().update(operationName,
					criteria);
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder()).append("Object updated [")
						.append(obj).append("]").toString());
		} catch (SQLException se) {
			org.springframework.dao.DataAccessException dae = super
					.getSqlMapClientTemplate().getExceptionTranslator()
					.translate("RetrieveObject", operationName, se);
			throw dae;
		}
		return obj;
	}
	
	public int updateObject(String operationName, Object criteria) {
		int obj ;
		try {
			
			obj = getSqlMapClient().update(operationName,
					criteria);
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder()).append("Object updated [")
						.append(obj).append("]").toString());
		} catch (SQLException se) {
			org.springframework.dao.DataAccessException dae = super
					.getSqlMapClientTemplate().getExceptionTranslator()
					.translate("RetrieveObject", operationName, se);
			throw dae;
		}
		return obj;
	}

	
	public void testDBConnectivity() {
		Map < String, Object > inputMap = new HashMap < String, Object > ();
		Object obj = getObject("common.getCount", inputMap);
		logger.info((new StringBuilder()).append("Object retrieved [")
				.append(obj).append("]").toString());
	}
	
	/**
	 * Returns single Object
	 * @param operationName
	 * @param criteria
	 * @return
	 */
	public Map getMap(String operationName, Map criteria, String key, String value) {
		Map obj = null;
		try {
			obj = getSqlMapClient().queryForMap(operationName, criteria, key,value);
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder()).append("Object retrieved [")
						.append(obj).append("]").toString());
		} catch (SQLException se) {
			org.springframework.dao.DataAccessException dae = super
					.getSqlMapClientTemplate().getExceptionTranslator()
					.translate("RetrieveObject", operationName, se);
			throw dae;
		}
		return obj;
	}

	public boolean deleteObject(String operationName, Object deleteObject) {
		Object obj = null;
		try {
			
			obj = getSqlMapClient().delete(operationName,
					deleteObject);
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder()).append("Object deleted [")
						.append(obj).append("]").toString());
		} catch (SQLException se) {
			org.springframework.dao.DataAccessException dae = super
					.getSqlMapClientTemplate().getExceptionTranslator()
					.translate("DeleteObject", operationName, se);
			throw dae;
		}
		boolean success=true;
		return success;
	}
	
}
