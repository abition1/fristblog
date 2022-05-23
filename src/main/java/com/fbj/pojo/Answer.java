package com.fbj.pojo;

import java.io.Serializable;

public class Answer implements Serializable {
    //错误码如果error为0表示运行ok，1为编译错误，2为命令运行出错…………很多很多状态
    private int error;
    //出错的提示信息-运行成功-编译错误-运行时错误。
    private String reason;
    public static String Success="运行成功";
    public static String Error="编译错误";
    public static String RuntimeError="运行时错误";
    //运行程序得到的标准输出
    private String stdout;
    //运行程序得到的标准错误
    private String stderr;
    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getStdout() {
        return stdout;
    }
    public void setStdout(String stdout) {
        this.stdout = stdout;
    }
    public String getStderr() {
        return stderr;
    }
    public void setStderr(String stderr) {
        this.stderr = stderr;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "error=" + error +
                ", reason='" + reason + '\'' +
                ", stdout='" + stdout + '\'' +
                ", stderr='" + stderr + '\'' +
                '}';
    }
}

