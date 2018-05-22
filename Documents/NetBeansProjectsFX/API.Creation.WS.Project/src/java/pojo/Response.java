/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 *
 * @author Aya
 */

@JsonPropertyOrder({ "status", "message", "error" })
public class Response {
    private boolean status;
    private String message;
    private int error;
    
    public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

       public int getError() {
        return error;
        }

       public void setError(int error) {
        this.error = error;
        }
       
}
