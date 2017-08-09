package issmi.jee.model;

public class User {
	String mail;
	String pwd;
	
	public User(String mail, String pwd) {
		this.mail=mail;
		this.pwd=pwd;
	}

	public String getMail() {
		return mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
