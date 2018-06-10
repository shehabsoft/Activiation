package com.user.response;


import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

 
 


@XmlRootElement(name="response")
@JsonInclude(Include.NON_NULL)
public class Response {
	 public Response()
	 {
		 
	 }
	public Response(int result_code, String message, String valid) {
		super();
		this.result_code = result_code;
		this.message = message;
		this.valid = valid;
	}
	private int result_code;
	
	private String message;
	 
	private String valid;
	 
	public int getResult_code() {
		return result_code;
	}
	public void setResult_code(int result_code) {
		this.result_code = result_code;
	}
	@JsonInclude(Include.NON_NULL)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@JsonInclude(Include.NON_NULL)
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
 
	
}
