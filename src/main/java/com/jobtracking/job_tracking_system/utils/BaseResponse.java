package com.jobtracking.job_tracking_system.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * common response
 *
 * @param <T>
 */
@Data
public class BaseResponse<T> implements Serializable {

  private int code;

  private T data;

  private String message;

  private String detail;

  public BaseResponse(int code, T data, String message, String detail) {
    this.message = message;
    this.data = data;
    this.code = code;
    this.detail = detail;
  }

  public BaseResponse(int code, T data, String message) {
    this.code = code;
    this.data = data;
    this.message = message;
  }

  public BaseResponse(int code, T data) {
    this.code = code;
    this.data = data;
  }

  public BaseResponse(ErrorCode errorCode) {
    this.code = errorCode.getCode();
    this.data = null;
    this.message = errorCode.getMessage();
    this.detail = errorCode.getDetail();
  }


}