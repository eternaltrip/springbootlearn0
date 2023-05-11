package com.bonc.migu.controller;


import com.bonc.migu.pojo.Music;
import com.bonc.migu.utils.ReturnObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class TagController {


    //1.根据场景查询标签
    @GetMapping("/tag/getTagsByScene")
    public ReturnObject getTagsByScene(@RequestParam String firmName){



        return ReturnObject.OK(null);
    }

    //2.根据标签查询歌曲

    @GetMapping("/music/recommend")
    public ReturnObject musicRecommend(@RequestParam String firmName){


        Music music =new Music();
        return ReturnObject.OK(music);
    }



    //3.上报歌曲标签数据
    @PostMapping("/music/uploadInfo")
    public ReturnObject musicUp(@RequestBody Music music){

        //执行添加
        return ReturnObject.OK(null);
    }


    //4.返回所有的场景-标签信息
    @GetMapping("/tag/all")
    public ReturnObject all(){



        return ReturnObject.OK(null);
    }




}
