package org.woo.persist.dao.impl;

import org.woo.persist.dao.ITokenDao;
import org.springframework.stereotype.Repository;
@Repository
public class TokenDao implements ITokenDao{

	@Override
	public void remove(String... keys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePattern(String pattern) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean set(String key, Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean set(String key, Object value, Long expireTime) {
		// TODO Auto-generated method stub
		return false;
	}

}
