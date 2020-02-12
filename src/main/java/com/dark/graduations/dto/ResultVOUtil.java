package com.dark.graduations.dto;

import com.dark.graduations.vo.Meta;
import com.dark.graduations.vo.ResultVO;

public class ResultVOUtil {
    //成功处理请求回调结果
    public static ResultVO success(Object object, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setMeta(new Meta(msg, 200));
        return resultVO;
    }

    //无返回数据成功处理结果
    public static ResultVO success(String msg) {
        return success(null, msg);
    }


    public static ResultVO error(String msg, Integer status) {
        ResultVO resultVO = new ResultVO();
        resultVO.setMeta(new Meta(msg, status));
        return resultVO;
    }

    public static ResultVO error(Object object, String msg, Integer status) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setMeta(new Meta(msg, status));
        return resultVO;
    }
}
