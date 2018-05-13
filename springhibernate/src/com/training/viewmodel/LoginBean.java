package com.training.viewmodel;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginBean
{		
		@NotEmpty
		@Email
		private String username;

		@NotEmpty(message = "Please enter your password.")
	    @Size(min = 6, max = 15, message = "Your password must be between 6 and 15 characters")
		private String password;
		
		private int age;

		public String getPassword()
		{
				return this.password;
		}

		public String getUsername()
		{
				return this.username;
		}

		public void setUsername(String username)
		{
				this.username = username;
		}

		public void setPassword(String password)
		{
				this.password = password;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
}
