package com.werun.onlinenote_backend.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @ClassName IndexResult
 * @Description Note类结果封装
 * @Author liuzijun
 * @Updater
 * @Create 2022-03-26
 * @Update
 **/
@Data
@NoArgsConstructor
public class IndexResult {
    private String message;
    private Boolean success;
    private String token;

    public IndexResult(String message,Boolean success,String token){
        this.message = message;
        this.success = success;
        this.token = token;
    }
    public IndexResult(String message,Boolean success){
        this.message = message;
        this.success = success;
    }
}
