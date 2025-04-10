package com.jobtracking.job_tracking_system.utils;


/**
 * Error Code
 */
public enum ErrorCode {

    SUCCESS(0, "Success", ""),
    PRAMS_ERROR(40000, "Request Params Error", ""),
    NULL_ERROR(40001, "No Requested Data", ""),
    NOT_LOGIN_ERROR(40100, "Not Logged In", ""),
    NO_AUTH(40101, "No Authentication", ""),
    SYSTEM_ERROR(50000, "System Error", "");
  
    private final int code;
  
    /**
     * status code message
     */
    private final String message;
  
    /**
     * error code details
     */
    private final String detail;
  
    ErrorCode(int code, String message, String detail) {
      this.code = code;
      this.message = message;
      this.detail = detail;
    }
  
    public int getCode() {
      return code;
    }
  
    public String getMessage() {
      return message;
    }
  
    public String getDetail() {
      return detail;
    }
  }
