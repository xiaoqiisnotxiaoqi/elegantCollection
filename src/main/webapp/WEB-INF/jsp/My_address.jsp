<%--
  Created by IntelliJ IDEA.
  User: rzz
  Date: 2018/10/29
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>地址本</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my_Elegant.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/My_address.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/myaddress.js"></script>


</head>
<body>


<jsp:include page="top.jsp" flush="true" />
<div class="mydang" id="J_muneAndContentWrap">
    <div class="my_left">
        <div class="my_menu">

            <h3 class="my_menu-title"><a href="${pageContext.request.contextPath}/myelegant">我的雅志</a></h3>
            <div class="dl">
                <!--导航栏开始-->


                <ul>我的交易</ul>
                <li><a href="${pageContext.request.contextPath}/order_all">我的订单</a></li>
                <ul>我的钱包</ul>
                <!--<li><a href="#">我的余额</a></li>-->
                <li><a href="${pageContext.request.contextPath}/myelegant">我的积分</a></li>
                <ul>售后服务</ul>
                <li><a href="#">申请/查询退换货</a></li>

                <ul>个人中心</ul>
                <li><a href="${pageContext.request.contextPath}/userinfo">个人信息</a></li>

                <li><a href="${pageContext.request.contextPath}/myaddress">收货地址</a></li>

                <ul>我的消息</ul>
                <li><a href="${pageContext.request.contextPath}/postReply">消息查看</a></li>
                <!--<li><a href="#">发帖记录</a></li>-->
                <li><a href="${pageContext.request.contextPath}/myEvaluate">评论/晒单</a></li>

            </div>
            <!--导航栏结束-->
        </div>
    </div>
    <!--左导航栏结束-->


    <div class="my_main">
        <div class="my_title">
            <a href="javascript:showaddress();" class="fr btn" id="J-Add-Address">+添加新地址</a>


            <span class="title">收货地址管理</span>
            <span class="tip">您已创建了<span class="red" id="J-Address-Num">0</span>个收货地址，最多可以创建
            <span class="red">20</span>个</span>
        </div>

        <div class="address_list">
            <ul id="J-Address-List">

            </ul>
            <div id="J-Page-Info" style="padding-right: 23px;"></div>

        </div>

        <input type="hidden" id="J-totalPageIndex">
        <input type="hidden" id="J-currentPageIndex">
    </div>

<div class="pop" style="display: none" id="J-Pop-Content">
    <a href="javascript:closeaddress()" class="close" id="J-Pop-Close"></a>
    <div class="pop_title" id="modtext">新增收货地址</div>
    <div class="pop_con">
        <form action="" method="" class="info_list">
            <ul>
                <li>
                    <span class="name">
                        <span class="red">*</span>
                        收货人
                    </span>
                    <input type="text" name="consigneeName" id="J-Cust-Name" maxlength="25">
                </li>
                <li style="z-index:3">
                    <span class="name">
                        <span class="red">*</span>
                        所在地区
                    </span>
                    <div class="select_add" id="area">
                        <select name="province" id="province" data-name="省份">
                            <option>加载中</option>
                        </select>
                        <select name="city" id="city" data-name="城市">
                            <option>请选择城市</option>
                        </select>
                        <select name="district" id="district" data-name="区/县">
                            <option>请选择区/县</option>
                        </select>

                    </div>
                </li>
                <li style="z-index: 2">
                    <span class="name">
                        <span class="red">*</span>
                        详情地址
                    </span>
                    <input type="text" style="width:413px;" id="J-Detail-Address" name="addressDetail" maxlength="50">
                    <div class="alart_tip" style="display: none" id="J-Detail-Tip">
                        <span class="icon_wrong"></span>
                        请填写详细街道地址,要求3个汉字以上
                    </div>
                </li>
                <li>
                    <span class="name">
                        <span class="red">*</span>
                        手机号码
                    </span>
                    <input type="text" id="J-Mobile-Phone" name="consigneePhone" maxlength="20">
                    <input type="hidden" id="Mobile-Bak">
                    <div class="alart_tip" style="display: none" id="J-Mobile-Tip"></div>
                </li>
            </ul>
        </form>

        <div class="btn_bar" id="save" style="display: none;">
            <input type="button" class="btn" id="J-Save-Address" onclick="saveadd()"  value="保存地址">
        </div>

        <div class="btn_bar" id="updata1" style="display: none">
            <input type="button" class="btn" id="J-updata-Address" onclick="updataadd()"  value="保存地址">

        </div>



    </div>
</div>
    <div class="pop delete" id="delete_sure" style="display: none">
    <a href="" class="close"></a>
    <div class="delete_con">
        <h2>确定要删除改地址吗?</h2>
        <div class="btn_bar">
            <a href="" class="btn" id="delete_yes">确定</a>
            <span class="btn cancle" id="delete_no">取消</span>
        </div>
    </div>
</div>

</div>
<!--mydang结束-->
<!--右侧栏-->
<div class="sidebar_wrap" id=sidebar_warp_id style="height:763px ">
    <div class="sidebar">
        <!--右侧栏的    二维码-->
        <div class="sidebar_code2">
            <a class="code2s"></a>

        </div>
        <!--购物车-->
        <div class="sidebar_cart">
            <a href="${pageContext.request.contextPath}/custCart">
                <span></span>
                购<br>物<br>车<br>
                <em id="cartnum"></em>
            </a>
        </div>
        <!--页面回滚-->
        <div class="sidebar_link">
            <a href="#" class="back_top"></a>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    var getCart ="${pageContext.request.contextPath}/cartNum";

    var xhr=null;
    function getCartNum() {
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP")
        }
        // console.log(area);
        xhr.open("GET", getCart, true);

        xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");

        xhr.onreadystatechange =loadCartNum;
        xhr.send();
    }
    function loadCartNum() {
        if(xhr.readyState==4 || xhr.state ==200){
            var result =JSON.parse(xhr.responseText)
            // alert(result);
            var cartnum =   document.getElementById("cartnum");
            cartnum.innerText="";
            cartnum.innerText+=(result);
        }

    }




    function showaddress() {
        document.getElementById("J-Pop-Content").style.display="block";
        document.getElementById("save").style.display ="block";
        document.getElementById("modtext").innerText="新增收货地址";
    }
    //回滚到头部
    $(function () {
        $('.back_top').click(function () {
            $('html , body').animate({scrollTop: 0}, 400);
        });

        //获得select
        $areaSelect = $("#area select");
        $areaSelect.hide();
        setOptions(0, $areaSelect.first());
       //递归调用
        $areaSelect.change(function () {
            $(this).nextAll().hide();
            setOptions($(this).val(), $(this).next())
        })
    });
//设置option
    function setOptions(parentId, $dom) {
        $dom.html("<option>加载中</option>");
        $dom.show();
        //传入parentId 查询所有
        $.get("/area/" + parentId, function (data) {
            var optionHtml = "<option>请选择" + $dom.attr("data-name") + "</option>";
            for (var i in data) {
                optionHtml += "<option value=" + data[i].id + ">" + data[i].name + "</option>";
            }
            $dom.html(optionHtml);
        });
    }


    var get_address= "${pageContext.request.contextPath}/getcustomer/address";
    var del_address ="${pageContext.request.contextPath}/delete";
    var insertAddress = "${pageContext.request.contextPath}/insertAddress";
    var updataAddress ="${pageContext.request.contextPath}/updataAddress";

    window.onload=function() {
        getAddress(get_address);

    }
    //获得所有的地址
    var xhr=null;
    function getAddress(get_address) {
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP")
        }


        // console.log(area);
        xhr.open("GET", get_address, true);

        xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");

        xhr.onreadystatechange =loadaddress;
        xhr.send();

    }
    function loadaddress() {

        console.log(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == 200) {
            var result = JSON.parse(xhr.responseText);
            // alert(result);

                var Address_list = document.getElementById("J-Address-List");
                Address_list.innerHTML = "";
                var addresslist = result;
                for (var i=0; i < addresslist.length; i++) {

                    //页面渲染
                    Address_list.innerHTML += ('<li class="addr" id="">' +
                        '                    <h1>' +
                        '                    ' +
                        '                    <i class="icon man"></i>' + addresslist[i].consigneeName +
                        '                   </h1>' +
                        '                    <p><i class="icon lbs"></i>' +
                        '                        <span class="txt">'
                            + addresslist[i].province +'&nbsp'+ addresslist[i].city + '&nbsp'+addresslist[i].district +'&nbsp' +
                        '&nbsp&nbsp&nbsp&nbsp<br/>'+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'+addresslist[i].addressDetail +
                        '                        </span>' +
                        '                    </p>' +
                        '                    <p>' +
                        '                        <i class="icon tel"></i>' +
                        '                        <span>' + addresslist[i].consigneePhone + '</span>' +
                        '                    </p>' +
                        '                    <span class="op">' +
                        '                        <a onclick = "modifyadd(this)" id="updata" name="'+addresslist[i].addressId+'"  class="ed" >修改</a>' +
                        '                        <a  onclick="isdel(this)" id="del"  name="'+addresslist[i].addressId+'" class="de">删除</a>' +
                        '                    </span>' +
                        '                   </li>');


                }
                var OrderNum =   document.getElementById('J-Address-Num');
                OrderNum.innerHTML= "";
                OrderNum.innerHTML+=('<strong>'+addresslist.length+'</strong>');
              getCartNum();

            }
    }

    var xhr = null;

//添加地址
    function saveadd() {
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP")
        }
        var consigneeName = document.getElementById("J-Cust-Name").value;
        var province = document.getElementById("province").value;


        var city = document.getElementById("city").value;

        var district = document.getElementById("district").value;

        var addressDetail = document.getElementById("J-Detail-Address").value;
        var consigneePhone = document.getElementById("J-Mobile-Phone").value;

        var area = "consigneeName=" + consigneeName + "&province=" + province + "&city=" + city + "&district=" + district
            + "&addressDetail=" + addressDetail + "&consigneePhone=" + consigneePhone;

         // console.log(area);
        xhr.open("POST", insertAddress, true);

        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");

        xhr.onreadystatechange = renderaddress;
        xhr.send(area);

    }

    function renderaddress() {
        document.getElementById("J-Pop-Content").style.display="none";
        getAddress(get_address);

    }
//删除地址
    function delAdd(){
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject('Microsoft.XMLHTTP');
        }

        var addressId = delId;

        del_address +="?id="+addressId;

        xhr.open("DELETE", del_address,true);
        xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");
        xhr.onreadystatechange =load1;
        xhr.send();
    }
    function load1() {
        window.location.reload();
    }




    $(function () {
            $(".close").click(function () {
                $("#delete_sure").css('display','none');
            })
        });
    $(function () {
        $("#delete_no").click(function () {
            $("#delete_sure").css('display','none');
        })
    });
    $(function () {
        $("#delete_yes").click(function () {
            $("#delete_sure").css('display','none');
            delAdd();

        })
    });
    var modId ;
//修改地址
    function modifyadd(ele) {
        document.getElementById("J-Pop-Content").style.display="block";
        document.getElementById("updata1").style.display="block";
        document.getElementById("J-Save-Address").style.display="none";
        document.getElementById("modtext").innerText="修改收货地址";
        modId = ele.name;
    }
    var delId;
    function isdel(ele) {
        // alert("是否进来")
        document.getElementById("delete_sure").style.display="block";

        delId= ele.name;
    }
//更新地址
function updataadd() {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject("Microsoft.XMLHTTP")
    }
    var addressId = modId;


    var consigneeName = document.getElementById("J-Cust-Name").value;
    var province = document.getElementById("province").value;


    var city = document.getElementById("city").value;

    var district = document.getElementById("district").value;

    var addressDetail = document.getElementById("J-Detail-Address").value;
    var consigneePhone = document.getElementById("J-Mobile-Phone").value;

    var area = "addressId=" +addressId+ "&consigneeName=" + consigneeName + "&province=" + province + "&city=" + city + "&district=" + district
        + "&addressDetail=" + addressDetail + "&consigneePhone=" + consigneePhone;


    // console.log(area);
    xhr.open("POST",updataAddress , true);

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");

    xhr.onreadystatechange = load1;
    xhr.send(area);


}




</script>

<jsp:include page="bottom.jsp" flush="true" />
</body>
</html>