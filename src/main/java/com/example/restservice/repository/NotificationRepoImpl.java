package com.example.restservice.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ChildAddress;

@Repository
public class NotificationRepoImpl implements NotificationCustomRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Configure the entity manager to be used.
	 *
	 * @param em the {@link EntityManager} to set.
	 */
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	@Override
	public String getEmailIdsByOrg(Integer id) {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("ChildAddress.getEmailIds");
		query.setParameter("OrgId", id);
		query.execute();
		Object result = query.getSingleResult();
		// TODO Auto-generated method stub
		System.out.println("Result "+result);
		return result.toString();
	}

	
	@Override
	public String getMobileNumbers(Integer id) {
		Map<String, Object> paramMap  = new HashMap<String, Object>();
		paramMap.put("OrgId", id);
		return executeStoredProc("ChildAddress.getMobileNos", paramMap);
	}

	@Override
	public String getRhTypes(Integer rhNo) {
		Map<String, Object> paramMap  = new HashMap<String, Object>();
		paramMap.put("RHNo", rhNo);
		return executeStoredProc("ChildAddress.getRhTypes", paramMap);
	}

	@Override
	public String getRhCodes(Integer rhNo) {
		Map<String, Object> paramMap  = new HashMap<String, Object>();
		paramMap.put("RHNo", rhNo);
		return executeStoredProc("ChildAddress.getRhCodes", paramMap);
	}

	@Override
	public Integer getChildAge(Date dob) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Note this will work for String re
	public String executeStoredProc(String queryName, Map<String, Object> paramMap) {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery(queryName);
		paramMap.forEach((k, v) -> 
			query.setParameter(k, v)
		); 
		query.execute();
		Object result = query.getSingleResult();
		System.out.println("Result "+result);
		return result.toString();
	}
	
	


}
