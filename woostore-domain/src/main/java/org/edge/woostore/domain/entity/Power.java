/**
 * 
 */
package org.edge.woostore.domain.entity;

/**
 * <p>Description: </p>
 * @method 
 * @author Administrator
 * 权限数据
 */
public class Power {
	private String id;
	private String name;
	private String number;
	private boolean status;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRoleName() {
		return roleName;
	}

	private String roleName;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Power(String roleName) {
		this.roleName = roleName;
	}

	public Power(String roleName, String url) {
		this.roleName = roleName;
		this.url = url;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
