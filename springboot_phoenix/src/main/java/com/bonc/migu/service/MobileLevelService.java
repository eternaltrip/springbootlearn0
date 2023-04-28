package com.bonc.migu.service;


import com.bonc.migu.mapper.MobileLevelMapper;
import com.bonc.migu.pojo.MobileLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class MobileLevelService {


    @Autowired
    private MobileLevelMapper levelMapper;



    public List<MobileLevel> queryAll(){
        return levelMapper.queryAll();

    }

    public MobileLevel queryById(String id){
        return levelMapper.queryById(id);
    }

    public int save(MobileLevel level){
        return levelMapper.save(level);
    }

    public int save(List<MobileLevel> levels){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int size = levels.size();
        for (MobileLevel level_new : levels) {
            MobileLevel old = levelMapper.queryById(level_new.getMsisdn());
            if(old == null){
                //UPSERT
                level_new.setCreateTime(sdf.format(new Date()));
                levelMapper.save(level_new);
            }else if(level_new.getLevelStatus() == 1){
                //如果新上报的号码需要强制刷新等级
                level_new.setUpdateTime(sdf.format(new Date()));
                level_new.setCreateTime(old.getCreateTime());
                levelMapper.save(level_new);
            }else{
                size --;
                //已经存在了，不做任何操作
            }
        }
        return size;
    }

    public int deleteById(String id){
        return levelMapper.deleteById(id);
    }

}
