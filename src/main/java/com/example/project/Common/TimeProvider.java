/**
 * 
 */
package com.example.project.Common;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author FIKRI-PC
 *
 */
public class TimeProvider implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimpleDateFormat yyyyMMdd_hhmmssSSS() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	}
	
	public SimpleDateFormat yyyyMMdd_hhmmss() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	public SimpleDateFormat ddMMyyyy_hhmmss() {
		return new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	}
	
	public SimpleDateFormat yyyyMMdd() {
		return new SimpleDateFormat("yyyy-MM-dd");
	}

	public Date now() {
        return new Date();
    }

}
