package org.edge.woostore.utils.util;


import java.util.Properties;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncrypDataProperty extends PropertyPlaceholderConfigurer {
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	protected void processProperties(
			ConfigurableListableBeanFactory beanFactory, Properties props) {
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		DESUtil ints = new DESUtil();
		try {
			if (username != null) {
				props.setProperty("username", ints.decrypt(username));
			}
			if (username != null) {
				props.setProperty("password", ints.decrypt(password));
			}
			super.processProperties(beanFactory, props);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * DES ints = new DES(); try { if (username != null) {
		 * props.setProperty("username",ints.decodeDES(username, key)); } if
		 * (username != null) {
		 * props.setProperty("password",ints.decodeDES(password, key)); }
		 * super.processProperties(beanFactory, props); } catch (Exception e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */

	}
}
