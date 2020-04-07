package com.cczhilie.edu.order.utils;

import com.cczhilie.edu.order.vo.ResultVo;

/**
 * @author: GZC
 * @create: 2020-04-07 19:56
 * @description:
 **/
public class ResultVoUtil {

    public static ResultVo success(Object object) {
        ResultVo resultVO = new ResultVo();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
