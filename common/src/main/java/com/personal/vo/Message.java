/**
 *
 */
package com.personal.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    public static final Integer SUCCESS = 1;
    public static final Integer FIALED = 0;
    
    /**
     * 业务请求成功
     */
    public static final String REQ_SUCCESS = "200";
     
    /**
     * 系统异常
     */
    public static final String REQ_FAILED = "500";

    private Integer ret;

    private String code;

    private String msg;

    private Object data;

}
