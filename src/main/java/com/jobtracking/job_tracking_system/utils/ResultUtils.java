package com.jobtracking.job_tracking_system.utils;

/**
 * result utils
 */
public class ResultUtils {

    /**
     * success
     *
     * @param data response data
     * @return successful return
     * @param <T> data type
     */
    public static <T> BaseResponse<T> success(T data) {
      return new BaseResponse<>(0, data, "OK");
    }
  
    /**
     * error
     *
     * @param errorCode
     * @param message
     * @param detail
     * @return
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode, String message, String detail) {
      return new BaseResponse<>(errorCode.getCode(), null, message, detail);
    }
  
    /**
     * error
     *
     * @param errorCode
     * @param detail
     * @return
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode, String detail) {
      return new BaseResponse<>(errorCode.getCode(), null, errorCode.getMessage(), detail);
    }
  
    /**
     * error
     *
     * @param errorCode
     * @return
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
      return new BaseResponse<>(errorCode);
    }
  
    /**
     * error
     *
     * @param code
     * @param message
     * @param detail
     * @return
     */
    public static <T> BaseResponse<T> error(int code, String message, String detail) {
      return new BaseResponse<>(code, null, message, detail);
    }
  
  }
