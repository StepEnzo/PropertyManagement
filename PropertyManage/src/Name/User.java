/**
 * 
 */
package Name;

/**
 * @author gzc
 *
 */
public class User {

	
	private int id;
	private String account;
	private String password;
	private String email;
	private String username;
	private int usercontrol;
	private int rank;
	private String status;
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
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
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the phone to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the usercontrol
	 */
	public int getUsercontrol() {
		return usercontrol;
	}
	/**
	 * @param usercontrol the usercontrol to set
	 */
	public void setUsercontrol(int usercontrol) {
		this.usercontrol = usercontrol;
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
	

}
