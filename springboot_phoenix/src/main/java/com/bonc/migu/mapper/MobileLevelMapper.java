package com.bonc.migu.mapper;


import com.bonc.migu.pojo.MobileLevel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MobileLevelMapper {
    public List<MobileLevel> queryAll();

    public MobileLevel queryById(String id);

    public int save(MobileLevel level);

    public int deleteById(String id);


}
