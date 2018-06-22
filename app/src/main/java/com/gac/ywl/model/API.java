package com.gac.ywl.model;

import com.gac.ywl.component.net.request.EasyGetBuilder;
import com.gac.ywl.component.net.request.EasyPostBuilder;

import java.util.HashMap;

/**
 * @描述：
 * @file_name：com.gac.ywl.model
 * @author：gac
 * @time：2018/6/22:10:10
 */

public class API {



    private static EasyPostBuilder post(){
        HashMap<String,String> heads = new HashMap<>();
        return new EasyPostBuilder().headers(heads);
    }

    private static EasyGetBuilder get(){
        HashMap<String,String> heads = new HashMap<>();
        return new EasyGetBuilder().headers(heads);
    }
}
