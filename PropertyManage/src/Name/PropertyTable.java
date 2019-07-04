/**
 * 
 */
package Name;


import java.sql.*;

/**
 * @author gzc
 *
 */
public class PropertyTable {
	private int pid;//企业资产单个物品的id
	private int id;  //企业资产类别的id
	private String propertyname;//企业资产名称
	private String brand;//品牌
	private String modelnumber;//型号
	private String specification;//规格
	private String status;//状态，表示次资产当前是否可被领用
	private Date date; //采购日期
	/**
	 * 
	 */
	public PropertyTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
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
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
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
