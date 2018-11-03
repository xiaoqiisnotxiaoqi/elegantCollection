package com.elegantcollection.controller;

import com.elegantcollection.entity.Address;
import com.elegantcollection.entity.Area;
import com.elegantcollection.entity.Customer;
import com.elegantcollection.service.AddressService;
import com.elegantcollection.service.Areaservice;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AddressController {
    //注入Service 层
    @Autowired
    private AddressService addressService;

    @Autowired
    private Areaservice areaservice;


    /**
     * //根据custId查询到当前用户的所有地址
     * @param request 服务请求
     * @param response 响应
     * @return 返回所有地址
     * @throws ServletException 跑出异常
     * @throws IOException 异常
     */
    @GetMapping("/getcustomer/address")
    public List<Address> getaddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer c = (Customer) request.getSession().getAttribute("customer");
        return addressService.queryByAddress(c.getCustId());
    }

    /**
     * 根据传进来的值插入一条地址
     * @param consigneeName 收件人姓名
     * @param province 省份
     * @param city 城市
     * @param district 区/县
     * @param addressDetail 地址详情
     * @param consigneePhone 收件人手机号
     * @param request 服务器请求
     * @param response 服务器 响应
     * @return 返回一个 Area对象
     */
    @PostMapping("/insertAddress")
    public Map<String,Object> importAddress(@Param("consigneeName") String consigneeName,
                                            @Param("province") Integer province,
                                            @Param("city") Integer city ,
                                            @Param("district") Integer district,
                                            @Param("addressDetail")  String addressDetail,
                                            @Param("consigneePhone") String consigneePhone,
                             HttpServletRequest request, HttpServletResponse response){


        Customer customer = (Customer) request.getSession().getAttribute("customer");
        Map<String,Object> map = new HashMap<>();
       if(customer == null){
           map.put("err","用户未登录");
           return map;

       }else {
           Address address = new Address();
           Area area =new Area();
           address.setCustId(customer.getCustId());
           address.setConsigneeName(consigneeName);
           Area area1=areaservice.queryByName(province);
           address.setProvince( area1.getName());
           Area area2=areaservice.queryByName(city);
           address.setCity(area2.getName());
           Area area3=areaservice.queryByName(district);
           address.setDistrict(area3.getName());
           address.setAddressDetail(addressDetail);
           address.setConsigneePhone(consigneePhone);
           address.setAddressStatus(0);

           int result =  addressService.insertAddress(address);
        if(result >0) {
            map.put("msg", "success");
           List<Address> list =  addressService.queryByAddress(address.getCustId());
           map.put("list",list);

        }  else {
            map.put("msg", "fail");
        }
           return map;

       }

    }

    /**
     * 得到相信的上级id
     * @param parentId 传加进来的上级id
     * @return 返回一个list
     */
    @GetMapping("/area/{parentId}")
    public List<Area> showArea(@PathVariable  Integer parentId){

        return areaservice.queryAreaByParentId(parentId);
    }
    @DeleteMapping("/delete")
    public String deleteaddress(Integer id){
//        System.out.println(id);
        Address address =addressService.queryByAdd(id);
        address.setAddressStatus(1);
        int result = addressService.deteleaddress(address);
//        System.out.println(result);
        if (result != 0)
            return "success";
        return "fail";

    }

    /**
     * 更新地址
     * @param addressId 地址Id
     * @param consigneeName 收件人地址
     * @param province 省分Id
     * @param city 城市Id
     * @param district 区Id
     * @param addressDetail 地址详情
     * @param consigneePhone 收件人手机号
     * @param request 服务请求
     * @return 返回String类型
     */
    @PostMapping("/updataAddress")
        public String  updataadd(@Param("addressId") Integer addressId,
                            @Param("consigneeName") String consigneeName,
                            @Param("province") Integer province,
                            @Param("city") Integer city ,
                            @Param("district") Integer district,
                            @Param("addressDetail")  String addressDetail,
                            @Param("consigneePhone") String consigneePhone,
                            HttpServletRequest request){

        Customer customer = (Customer) request.getSession().getAttribute("customer");


        Address address = new Address();
        Area area =new Area();
        address.setCustId(customer.getCustId());
        System.out.println(customer.getCustId());
        address.setAddressId(addressId);
        address.setConsigneeName(consigneeName);
        Area area1=areaservice.queryByName(province);
        address.setProvince( area1.getName());
        Area area2=areaservice.queryByName(city);
        address.setCity(area2.getName());
        Area area3=areaservice.queryByName(district);
        address.setDistrict(area3.getName());
        address.setAddressDetail(addressDetail);
        address.setConsigneePhone(consigneePhone);
        address.setAddressStatus(0);
        int resoult =addressService.updateadd(address);
        System.out.println(address);
        System.out.println(resoult);

        return "success";
    }
}
