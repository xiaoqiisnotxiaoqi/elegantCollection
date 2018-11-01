package com.elegantcollection.controller;


import com.elegantcollection.entity.Area;
import com.elegantcollection.service.Areaservice;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

/**
 * 此类只用于导入地址数据
 *
 */
@RestController
public class ImportAreaData {

    private Areaservice areaService;

    @Autowired
    public void setAreaService(Areaservice areaService) {
        this.areaService = areaService;
    }
//开始导入
    @GetMapping("/import")
    public String importData() {
        JsonParser parse = new JsonParser();  //创建json解析器
        String path = "D:\\Tencent Files\\1501520190\\FileRecv\\pca.json"; //创建路径地址
        try {
            JsonElement json = parse.parse(new FileReader(path));//创建jsonObject对象 解析出来JSONElement是jsonObjectd的父类


            if (json.isJsonObject()) {//判断是不是json对象

                for (Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {//使用map确定文件输出的key value的值

                    // insert into area  (name, parent_id) values(entry.getKey(), 0)
                    // parent_id=0;
                    Area province = new Area();
                    province.setName(entry.getKey());
                    province.setParentId(0);//让省份的默认parent_id 等于0 ,因为省最大
                    areaService.insertArea(province);//把省份插入到表中,

                    for (Map.Entry<String, JsonElement> entry1 : entry.getValue().getAsJsonObject().entrySet()) {
                        // insert into area  (name, parent_id) values(entry.getKey(), pId)
                        // cid
                        Area city = new Area();
                        city.setName(entry1.getKey());
                        city.setParentId(province.getId());
                        areaService.insertArea(city);//把城市插入到表中
                        for (JsonElement area : entry1.getValue().getAsJsonArray()) {
                            System.out.println(area);
                            // insert into area  (name, parent_id) values(entry.getKey(), cid)
                            Area area1 = new Area();
                            area1.setName(area.getAsString());
                            area1.setParentId(city.getId());
                            areaService.insertArea(area1);//把区插入到表单中
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "ok";
    }


}
