package com.bonc.migu.controller;


import com.bonc.migu.pojo.MobileLevel;
import com.bonc.migu.service.MobileLevelService;
import com.bonc.migu.utils.ReturnObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/mobileLevel")
public class MobileLevelController {


    @Autowired
    private MobileLevelService mobileLevelService;


    @GetMapping(value = "/all" )
    public ReturnObject queryAll(){

        Random random = new Random();
        if(random.nextInt(10) % 3 == 0){
            int a = 1/0;
        }
        return ReturnObject.OK(mobileLevelService.queryAll());
    }
    @GetMapping(value = "/query")
    public ReturnObject  queryById(@RequestParam(required = true , name = "msisdn") String msisdn){

        msisdn = msisdn.trim().replaceAll(" ","");
        if(msisdn.length() != 11 ){
            return ReturnObject.error(ReturnObject.PARAM_ERROR_CODE ,"号码不正确！");
        }
        MobileLevel mobileLevel = mobileLevelService.queryById(msisdn);
        int level = 0;
        if(mobileLevel == null){
            save(msisdn ,null).getFlag();
        }else{
            level = mobileLevel.getLevel();
        }
        Map<String,Object> retVal = new HashMap<>();
        retVal.put("msisdn" , msisdn);
        retVal.put("level" , level);
        return ReturnObject.OK(retVal);
    }

    @PostMapping("/up")
    public ReturnObject  save(@RequestParam(required = true , name = "msisdns") String msisdns,
                    String levelstatus){
        if (StringUtils.isNotEmpty(levelstatus) && !"0".equals(levelstatus) && !"1".equals(levelstatus)){
            return ReturnObject.error(ReturnObject.PARAM_ERROR_CODE,"levelstatus参数有误，使用该参数时，只能是0或者1;不使用可不传递");
        }else {
            String[] mobileArr = msisdns.split(",");
            if(mobileArr.length > 2){
                return ReturnObject.error(HttpStatus.REQUEST_ENTITY_TOO_LARGE.value(), "单次上报手机不能超过1000条");
            }else{
                String uuid = UUID.randomUUID().toString();
                boolean status = true;
                List<MobileLevel> levels = new ArrayList<>();
                //判断是手机号码长度
                for (int i = 0; i < mobileArr.length; i++) {
                    String mobile = mobileArr[i].trim().replaceAll(" ","");
                    if(mobile.length() != 11){
                        return ReturnObject.param_error("单次上报手机不能超过1000条");
                    }else{
                        MobileLevel level = new MobileLevel();
                        level.setMsisdn(mobile);
                        level.setLevelStatus(StringUtils.isEmpty(levelstatus)? 0 : Integer.parseInt(levelstatus));
                        level.setLevel(0);
                        level.setSource("SYSTEM");
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


}
