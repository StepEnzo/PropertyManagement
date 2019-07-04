/**
 * 
 */
package Name;

/**
 * @author lenovo
 *
 */
public class AdminTable {
		private int id;
		private String account;
		private String password;
		private String phone;
		private String name;
		private int admincol;
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
		 * @return the admincol
		 */
		public int getAdmincol() {
			return admincol;
		}
		/**
		 * @param admincol the admincol to set
		 */
		public void setAdmincol(int admincol) {
			this.admincol = admincol;
		}
		/**
		 * @param id
		 * @param account
		 * @param password
		 * @param phone
		 * @param name
		 * @param admincol
		 */
		public AdminTable(int id, String account, String password, String phone, String name, int admincol) {
			super();
			this.id = id;
			this.account = account;
			this.password = password;
			this.phone = phone;
			this.name = name;
			this.admincol = admincol;
		}
		/**
		 * 
		 */
		public AdminTable() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}