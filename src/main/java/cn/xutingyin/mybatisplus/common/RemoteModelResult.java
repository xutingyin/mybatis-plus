package cn.xutingyin.mybatisplus.common;

import cn.xutingyin.mybatisplus.constant.ReturnCode;

import java.io.Serializable;

/**
 * 通用远程调用返回对象
 * @author xuty
 * @param <T> 返回具体对象
 */
public class RemoteModelResult<T extends Object> implements Serializable {
	private static final long serialVersionUID = -1496405684560284917L;
    /**
     * 业务对象
      */
	private T result;
    /**
     *   响应码
      */
	private String code = ReturnCode.SUCCESS.getCode();
    /**
     *  响应信息
     */
	private String msg = ReturnCode.SUCCESS.getDescription();
	
	public RemoteModelResult(){}

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	@Override
	public String toString() {
		return "RemoteModelResult [code=" + code
				+ ", msg=" + msg + "]";
	}

    /**
     * 失败
     * @param msg 提示信息
     * @return
     */
	public static RemoteModelResult failure(String msg){
		RemoteModelResult result=new RemoteModelResult();
		result.setCode(ReturnCode.FAILED.getCode());
		result.setMsg(msg);
		return result;
	}
}
