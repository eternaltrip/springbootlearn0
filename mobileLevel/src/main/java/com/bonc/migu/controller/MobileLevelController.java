package com.bonc.migu.controller;


import com.bonc.migu.pojo.MobileLevel;
import com.bonc.migu.service.MobileLevelService;
import com.bonc.migu.utils.ReturnObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/mobileLevel")
public class MobileLevelController {


    @Autowired
    private MobileLevelService mobileLevelService;


    @GetMapping(value = "/count" )
    public ReturnObject count(){
        return ReturnObject.OK(mobileLevelService.count());
    }

    @GetMapping(value = "/test" )
    public ReturnObject queryAll(){
        Random random = new Random();
        if(random.nextInt(10) % 3 == 0){
            int a = 1/0;
        }
        return ReturnObject.OK(mobileLevelService.count());
    }
    @GetMapping(value = "/query")
    public ReturnObject  queryById(@RequestParam(required = true , name = "msisdn") String msisdn){

        msisdn = msisdn.trim().replaceAll(" ","");
        if(msisdn.length() != 11 ){
            return ReturnObject.error(ReturnObject.PARAM_ERROR_CODE ,"号码不正确！");
        }
        MobileLevel mobileLevel = mobileLevelService.queryById(msisdn);
        if(mobileLevel == null){
            MobileLevel level = new MobileLevel();
            level.setMsisdn(msisdn);
            level.setLevelStatus(0);
            level.setLevel(0);
            level.setStatus(0);
            level.setUuid("USERQUERY");
            mobileLevelService.save(level);
        }
        Map<String,Object> retVal = new HashMap<>();
        retVal.put("msisdn" , msisdn);
        retVal.put("level" , mobileLevel == null ? 0 : mobileLevel.getLevel());
        return ReturnObject.OK(retVal);
    }

    @PostMapping("/up")
    public ReturnObject  save(@RequestParam(required = true , name = "msisdns") String msisdns,
                    String levelstatus){
        if (StringUtils.isNotEmpty(levelstatus) && !"0".equals(levelstatus) && !"1".equals(levelstatus)){
            return ReturnObject.error(ReturnObject.PARAM_ERROR_CODE,"levelstatus参数有误，使用该参数时，只能是0或者1;不使用可不传递");
        }else {
            String[] mobileArr = msisdns.split(",");
            if(mobileArr.length > 1000){
                return ReturnObject.error(HttpStatus.REQUEST_ENTITY_TOO_LARGE.value(), "单次上报手机不能超过1000条");
            }else{
                String uuid = UUID.randomUUID().toString();
                boolean status = true;
                List<MobileLevel> levels = new ArrayList<>();
                //判断是手机号码长度
                for (int i = 0; i < mobileArr.length; i++) {
                    String mobile = mobileArr[i].trim().replaceAll(" ","");
                    if(mobile.length() != 11){
                        return ReturnObject.param_error("号码有误！错位号码为："+mobileArr[i]);
                    }else{
                        MobileLevel level = new MobileLevel();
                        level.setMsisdn(mobile);
                        level.setLevelStatus(StringUtils.isEmpty(levelstatus)? 0 : Integer.parseInt(levelstatus));
                        level.setLevel(0);
                        level.setStatus(0);
                        level.setUuid(uuid);
                        levels.add(level);
                    }
                }
                //执行写入库操作
                mobileLevelService.save(levels);
                return ReturnObject.OK(null);
            }
        }
    }

    @GetMapping("/delete")
    public ReturnObject deleteById(@RequestParam(required = true , name = "msisdn") String msisdn){
        mobileLevelService.deleteById(msisdn);
        return ReturnObject.OK(null);
    }


//    @GetMapping("/genNum")
    public ReturnObject genNum(){

        StringBuffer stringBuffer = new StringBuffer();
        Random  random = new Random();

        for (int i = 0; i < 500; i++) {
            int num = 100000000 + random.nextInt(899999999);
            stringBuffer.append(",13").append(num);
        }
        return ReturnObject.OK(stringBuffer);
    }






}
