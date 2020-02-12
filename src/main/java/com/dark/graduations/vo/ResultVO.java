package com.dark.graduations.vo;


import lombok.Data;

@Data
public class ResultVO<T> {
    //返回具体内容
    private T data;

    private Meta meta;

}
