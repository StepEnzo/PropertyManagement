/**
 * 
 */
package Name;

import java.sql.Date;

/**
 * @author gzc
 *
 */
public class PusTable {

	private int userid;//用户自动生成的id
	private int propertyid;//资产id
	private String account;//用户账号名
	private String password;//用户密码
	private String phone;//用户电话
	private String username;//用户姓名
	private int id;  //企业资产类别的id
	private String propertyname;//企业资产名称
	private String brand;//资产品牌
	private String modelnumber;//资产型号
	private String specification;//资产规格
	private String status;//状态，表示当前事物的状态
	private Date buydate; //资产采购日期
	private Date date;//当前事物生成日期
	/**
	 * 
	 */
	public PusTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the propertyid
	 */
	public int getPropertyid() {
		return propertyid;
	}
	/**
	 * @param propertyid the propertyid to set
	 */
	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}
	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the propertyname
	 */
	public String getPropertyname() {
		return propertyname;
	}
	/**
	 * @param propertyname the propertyname to set
	 */
	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the modelnumber
	 */
	public String getModelnumber() {
		return modelnumber;
	}
	/**
	 * @param modelnumber the modelnumber to set
	 */
	public void setModelnumber(String modelnumber) {
		this.modelnumber = modelnumber;
	}
	/**
	 * @return the specification
	 */
	public String getSpecification() {
		return specification;
	}
	/**
	 * @param specification the specification to set
	 */
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the buydate
	 */
	public Date getBuydate() {
		return buydate;
	}
	/**
	 * @param buydate the buydate to set
	 */
	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
