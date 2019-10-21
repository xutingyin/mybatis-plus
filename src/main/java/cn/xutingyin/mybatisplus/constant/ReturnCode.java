package cn.xutingyin.mybatisplus.constant;
/**
* @Description: 返回枚举类
* @Author: xuty
* @Date: 2019/10/18 14:04
*/
public enum ReturnCode {
    SUCCESS("200","成功"),
    FAILED("400","失败");

    private String code;

    private String description;

    private ReturnCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }


    public String getDescription() {
        return description;
    }

    public static ReturnCode getReturnCodeByValue(String code) {
        for (ReturnCode returnCode : ReturnCode.values()) {
            if (returnCode.code.equals(code)) {
                return returnCode;
            }
        }
        return null;
    }
}
