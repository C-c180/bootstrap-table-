package com.project.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class ResopnseData {
    private int code;

    private String message="ok";

    private Map<String,Object> data=new HashMap<>();

    public ResopnseData() {

    }

    public ResopnseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResopnseData ok(){
        return new ResopnseData(200,"ok");
    }

    public static ResopnseData notFound(){
        return new ResopnseData(404,"not found");
    }

    public static ResopnseData unauthorized(){
        return new ResopnseData(401,"unauthorized");
    }
}
