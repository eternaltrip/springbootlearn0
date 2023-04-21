package com.bonc.migu.service;

import com.bonc.migu.utils.HBaseUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class MobileLevelService {
    @Autowired
    private HBaseUtils hbaseUtils;

    @Value("${mobilelevel.tablename}")
    private String tableName;
    @Value("${mobilelevel.columnFamily}")
    private String columnFamily;

    @Value("${mobilelevel.columns}")
    private String columns;



    /**
     * 上报手机号码接口
     * @param mobile
     * @return
     */
    public String queryLevel(String mobile ){
        Map<String, String> rowData = hbaseUtils.getData(tableName, mobile);
        if(rowData == null || StringUtils.isNotEmpty(rowData.get(columnFamily))){
            //不存在就新增
            String[] mobiles =  {mobile};
            upToDB( mobiles, "user");
            return "0";
        }
        return rowData.get("level");
    }


    /**
     * 上报手机号码接口
     * @param mobiles
     * @param source
     * @return
     */
    public boolean upToDB(String[] mobiles , String source){

        Boolean t = hbaseUtils.isExists(tableName);
        if(!t){
            hbaseUtils.createTable(tableName, Arrays.asList(columnFamily));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String now = sdf.format(new Date());
        if(mobiles.length == 1){
            hbaseUtils.putData(tableName, mobiles[0], columnFamily,
                    Arrays.asList(columns.split(",")),  Arrays.asList(UUID.randomUUID().toString(), mobiles[0], "0" ,source,now ,now ) );
        }else{
            for (String mobile : mobiles) {
                hbaseUtils.putData(tableName, mobile, columnFamily,
                        Arrays.asList(columns.split(",")),  Arrays.asList(UUID.randomUUID().toString(), mobile, "0" ,source,now ,now ) );
            }
        }
        return true;
    }





}