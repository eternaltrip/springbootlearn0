package com.bonc.migu.controller;


import com.bonc.migu.service.MobileLevelService;
import com.bonc.migu.utils.HBaseUtils;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/level")
public class MobileLevelController {


    @Autowired
    private HBaseUtils hbaseUtils;


    @Autowired
    private MobileLevelService mobileLevelService;

    @RequestMapping("/")
    public Object ok() {
        System.out.println("ok");
        return "ok";
    }


    @PostMapping("/up")
    public Object batchUP(@RequestParam(value = "mobiles",required = true) String mobiles){
        String code = "0000";
        String msg = "SUCCESS";
        if(StringUtils.isNotEmpty(mobiles)){
            if(mobiles.indexOf("|") > 0){
                String[] mobileArr = mobiles.split("|");
                boolean status = true;
                //判断是手机号码长度
                for (int i = 0; i < mobileArr.length; i++) {
                    if(mobileArr[i].trim().length() != 11){
                        code = "0002";
                        msg = "上报手机号码["+mobileArr[i]+"]不正确!";
                        status = false;
                        break;
                    }
                }
                if(status){
                    //执行写入库操作
                    mobileLevelService.upToDB(mobileArr,"system");
                }
            }
        }else{
             code = "0001";
             msg = "上报手机号码不能为空!";
        }
        Map<String,Object> retVal = new HashMap<>();
        retVal.put("code",code);
        retVal.put("message",msg);
        return retVal;
    }


    @PostMapping("/query")
    public Object query(@RequestParam(value = "mobiles",required = true) String mobiles){
        String code = "0000";
        String msg = "SUCCESS";
        String level = "0";
        if(StringUtils.isNotEmpty(mobiles) && mobiles.length() == 11){
            level = mobileLevelService.queryLevel(mobiles);
        }else{
            code = "0001";
            msg = "上报手机号码不能为空!";
        }
        Map<String,Object> retVal = new HashMap<>();
        retVal.put("code",code);
        retVal.put("message",msg);
        retVal.put("level",level);
        return retVal;
    }





    @GetMapping("/test")
    public void createTable() throws IOException {
        System.out.println("---开始创建test表---");
        hbaseUtils.createTable("test", Arrays.asList("cf"));

        System.out.println("---判断test表是否存在---");
        Boolean t = hbaseUtils.isExists("test");
        System.out.println(t);

        System.out.println("\n---插入一列数据---");
        hbaseUtils.putData("test", "row1", "cf", "a", "value1-1");

        System.out.println("\n---插入多列数据---");
        hbaseUtils.putData("test", "row2", "cf",
                Arrays.asList("a", "b", "c"),  Arrays.asList("value2-1", "value2-2", "value2-3"));

        System.out.println("\n---根据rowkey、列族、列查询数据---");
        String columnData = hbaseUtils.getData("test", "row2", "cf", "b");
        System.out.println(columnData);

        System.out.println("\n---根据rowkey查询数据---");
        Map<String, String> rowData = hbaseUtils.getData("test", "row2");
        System.out.println(rowData);

        System.out.println("\n---查询全表数据---");
        List<Map<String, String>> tableData = hbaseUtils.getData("test");
        System.out.println(tableData);

        System.out.println("\n---根据rowkey、列族、列删除数据---");
        hbaseUtils.deleteData("test", "row2", "cf", "b");

        System.out.println("\n---根据rowkey、列族删除数据---");
        hbaseUtils.deleteData("test", "row2", "cf");

        System.out.println("\n---根据rowkey删除数据---");
        hbaseUtils.deleteData("test", "row2");

        System.out.println("\n---根据rowkey批量删除数据---");
        hbaseUtils.deleteData("test", Arrays.asList("row1", "row2"));

        System.out.println("\n---删除表---");
        hbaseUtils.dropTable("test");
    }

}
