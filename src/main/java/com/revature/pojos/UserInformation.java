package com.revature.pojos;

import java.util.List;

public class UserInformation {
	
	private User user;
	private List<AccountInfo> account;
	
	public UserInformation() {}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<AccountInfo> getAccount() {
		return account;
	}

	public void setAccount(List<AccountInfo> account) {
		this.account = account;
	}

}


