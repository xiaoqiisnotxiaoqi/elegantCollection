<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑个人信息档案</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_info.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my_Elegant.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/user_info.js"></script>
</head>
<body>
<jsp:include page="top.jsp" flush="true"/>






<div class="mydnew_break">

    您现在的位置：
    <a href="#">雅志</a> &gt;
    <span><a href="#">我的Elegant</a></span> &gt;
    <span>个人档案</span>
</div>
    <!--个人信息开始操作-->
    <div class="main_frame">
        <!--左侧栏开始-->
        <div class="my_left">
            <div class="my_menu">

                <h3 class="my_menu-title"><a href="#">我的雅志</a></h3>
                <div class="dl">
                    <!--导航栏开始-->

                    <ul>我的交易</ul>
                    <li><a href="#">我的订单</a></li>
                    <ul>我的钱包</ul>
                    <!--<li><a href="#">我的余额</a></li>-->
                    <li><a href="#">我的积分</a></li>
                    <ul>售后服务</ul>
                    <li><a href="#">申请/查询退换货</a></li>

                    <ul>个人中心</ul>
                    <li><a href="#">个人信息</a></li>

                    <li><a href="#">收货地址</a></li>
                    <ul>安全中心</ul>
                    <li><a href="#">登录密码</a></li>
                    <li><a href="#">邮箱验证</a></li>
                    <li><a href="#">手机绑定</a></li>
                    <ul>我的消息</ul>
                    <li><a href="#">消息查看</a></li>
                    <!--<li><a href="#">发帖记录</a></li>-->
                    <li><a href="#">评论/晒单</a></li>
                    <li><a href="#">提问/回答</a></li>
                </div>
                <!--导航栏结束-->
            </div>
        </div>


        <!--左侧结束-->
        <!--右侧开始-->
        <div class="account_right" id="your_position">
            <div>
                <div class="archives_title">
                    <h2>
                        编辑个人档案
                        <span class="gray666 f12 bnone">( 带<span class="red">*</span>号的项目为必填项 )</span>
                    </h2>
                </div>



                <!--更换头像-->
                <div class="edit_message">
                    <div class="edit_photo">
                        <div class="photo_prev">
                            <div class="photo_prev_head">
                                <img id="img_head_select" src="">
                            </div>
                        </div>

                        <div class="photo_browse">
                            <input type="hidden" id="hiddenphototypeid" value="0">
                            <input type="hidden" id="hinddenimgindex" value="0">
                            <input type="hidden" name="is_from_mydd" value="false">

                            <!--上传状态开始-->
                            <!--上传状态结束-->
                            <p class="go_choice2">你可以在下方选择自己喜欢的头像:</p>
                            <span class="gray_b3">( 更新后的头像将稍后显示在其他页面上 )</span>
                            <div class="clear"></div>
                            <div class="all_photo_title">

                                <div class="all_photo_title_mo" id="head_type_0"
                                     onmouseover="javascript:ShowHeadPhotoType(0)">酷男
                                </div>

                                <div class="all_photo_title_other" id="head_type_1"
                                     onmouseover="javascript:ShowHeadPhotoType(1)">靓女
                                </div>
                                <div class="all_photo_title_other" id="head_type_2"
                                     onmouseover="javascript:ShowHeadPhotoType(2)">
                                    可爱动物
                                </div>
                                <div class="all_photo_title_other" id="head_type_3"
                                     onmouseover="javascript:ShowHeadPhotoType(3)">个性
                                </div>
                            </div>
                            <div class="clear"></div>
                            <div class="all_photo" id="all_photo_0" style="display: block;">
                                <div id="head_index_1" onmouseover="mouseoverchangeclass(1)"
                                     onmouseout="mouseoutchangeclass(1)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(1)" style="cursor:pointer">
                                        <img src="../images/pic_head_1_s.gif"></a>
                                </div>
                                <div id="head_index_2" onmouseover="mouseoverchangeclass(2)"
                                     onmouseout="mouseoutchangeclass(2)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(2)" style="cursor:pointer">
                                        <img src="../images/pic_head_2_s.gif"></a>
                                </div>
                                <div id="head_index_3" onmouseover="mouseoverchangeclass(3)"
                                     onmouseout="mouseoutchangeclass(3)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(3)" style="cursor:pointer">
                                        <img src="../images/pic_head_3_s.gif"></a>
                                </div>
                                <div id="head_index_4" onmouseover="mouseoverchangeclass(4)"
                                     onmouseout="mouseoutchangeclass(4)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(4)" style="cursor:pointer">
                                        <img src="../images/pic_head_4_s.gif"></a>
                                </div>
                                <div id="head_index_5" onmouseover="mouseoverchangeclass(5)"
                                     onmouseout="mouseoutchangeclass(5)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(5)" style="cursor:pointer">
                                        <img src="../images/pic_head_5_s.gif"></a>
                                </div>
                                <div id="head_index_6" onmouseover="mouseoverchangeclass(6)"
                                     onmouseout="mouseoutchangeclass(6)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(6)" style="cursor:pointer">
                                        <img src="../images/pic_head_6_s.gif"></a>
                                </div>
                                <div id="head_index_7" onmouseover="mouseoverchangeclass(7)"
                                     onmouseout="mouseoutchangeclass(7)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(7)" style="cursor:pointer">
                                        <img src="../images/pic_head_7_s.gif"></a>
                                </div>
                                <div id="head_index_8" onmouseover="mouseoverchangeclass(8)"
                                     onmouseout="mouseoutchangeclass(8)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(8)" style="cursor:pointer">
                                        <img src="../images/pic_head_8_s.gif"></a>
                                </div>
                                <div id="head_index_9" onmouseover="mouseoverchangeclass(9)"
                                     onmouseout="mouseoutchangeclass(9)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(9)" style="cursor:pointer">
                                        <img src="../images/pic_head_9_s.gif"></a>
                                </div>
                                <div id="head_index_10" onmouseover="mouseoverchangeclass(10)"
                                     onmouseout="mouseoutchangeclass(10)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(10)" style="cursor:pointer">
                                        <img src="../images/pic_head_10_s.gif"></a>
                                </div>
                            </div>
                            <div class="all_photo" id="all_photo_1" style="display :none ">
                                <div id="head_index_11" onmouseover="mouseoverchangeclass(11)"
                                     onmouseout="mouseoutchangeclass(11)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(11)"><img
                                            src="../images/pic_head_11_s.gif"></a>
                                </div>
                                <div id="head_index_12" onmouseover="mouseoverchangeclass(12)"
                                     onmouseout="mouseoutchangeclass(12)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(12)">
                                        <img src="../images/pic_head_12_s.gif"></a>
                                </div>
                                <div id="head_index_13" onmouseover="mouseoverchangeclass(13)"
                                     onmouseout="mouseoutchangeclass(13)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(13)">
                                        <img src="../images/pic_head_13_s.gif"></a>
                                </div>
                                <div id="head_index_14" onmouseover="mouseoverchangeclass(14)"
                                     onmouseout="mouseoutchangeclass(14)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(14)">
                                        <img src="../images/pic_head_14_s.gif"></a>
                                </div>
                                <div id="head_index_15" onmouseover="mouseoverchangeclass(15)"
                                     onmouseout="mouseoutchangeclass(15)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(15)">
                                        <img src="../images/pic_head_15_s.gif"></a>
                                </div>
                                <div id="head_index_16" onmouseover="mouseoverchangeclass(16)"
                                     onmouseout="mouseoutchangeclass(16)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(16)">
                                        <img src="../images/pic_head_16_s.gif"></a>
                                </div>
                                <div id="head_index_17" onmouseover="mouseoverchangeclass(17)"
                                     onmouseout="mouseoutchangeclass(17)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(17)">
                                        <img src="../images/pic_head_17_s.gif"></a>
                                </div>
                                <div id="head_index_18" onmouseover="mouseoverchangeclass(18)"
                                     onmouseout="mouseoutchangeclass(18)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(18)">
                                        <img src="../images/pic_head_18_s.gif"></a>
                                </div>
                                <div id="head_index_19" onmouseover="mouseoverchangeclass(19)"
                                     onmouseout="mouseoutchangeclass(19)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(19)">
                                        <img src="../images/pic_head_19_s.gif"></a>
                                </div>
                                <div id="head_index_20" onmouseover="mouseoverchangeclass(20)"
                                     onmouseout="mouseoutchangeclass(20)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(20)">
                                        <img src="../images/pic_head_20_s.gif"></a>
                                </div>
                            </div>
                            <div class="all_photo" id="all_photo_2" style="display: none;">
                                <div id="head_index_21" onmouseover="mouseoverchangeclass(21)"
                                     onmouseout="mouseoutchangeclass(21)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(21)">
                                        <img src="../images/pic_head_21_s.gif"></a>
                                </div>
                                <div id="head_index_22" onmouseover="mouseoverchangeclass(22)"
                                     onmouseout="mouseoutchangeclass(22)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(22)">
                                        <img src="../images/pic_head_22_s.gif"></a>
                                </div>
                                <div id="head_index_23" onmouseover="mouseoverchangeclass(23)"
                                     onmouseout="mouseoutchangeclass(23)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(23)">
                                        <img src="../images/pic_head_23_s.gif"></a>
                                </div>
                                <div id="head_index_24" onmouseover="mouseoverchangeclass(24)"
                                     onmouseout="mouseoutchangeclass(24)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(24)">
                                        <img src="../images/pic_head_24_s.gif"></a>
                                </div>
                                <div id="head_index_25" onmouseover="mouseoverchangeclass(25)"
                                     onmouseout="mouseoutchangeclass(25)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(25)">
                                        <img src="../images/pic_head_25_s.gif"></a>
                                </div>
                                <div id="head_index_26" onmouseover="mouseoverchangeclass(26)"
                                     onmouseout="mouseoutchangeclass(26)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(26)">
                                        <img src="../images/pic_head_26_s.gif"></a>
                                </div>
                                <div id="head_index_27" onmouseover="mouseoverchangeclass(27)"
                                     onmouseout="mouseoutchangeclass(27)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(27)">
                                        <img src="../images/pic_head_27_s.gif"></a>
                                </div>
                                <div id="head_index_28" onmouseover="mouseoverchangeclass(28)"
                                     onmouseout="mouseoutchangeclass(28)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(28)">
                                        <img src="../images/pic_head_28_s.gif"></a>
                                </div>
                                <div id="head_index_29" onmouseover="mouseoverchangeclass(29)"
                                     onmouseout="mouseoutchangeclass(29)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(29)">
                                        <img src="../images/pic_head_29_s.gif"></a>
                                </div>
                                <div id="head_index_30" onmouseover="mouseoverchangeclass(30)"
                                     onmouseout="mouseoutchangeclass(30)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(30)">
                                        <img src="../images/pic_head_30_s.gif"></a>
                                </div>
                            </div>
                            <div class="all_photo" id="all_photo_3" style="display :none ">
                                <div id="head_index_31" onmouseover="mouseoverchangeclass(31)"
                                     onmouseout="mouseoutchangeclass(31)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(31)">
                                        <img src="../images/pic_head_31_s.gif"></a>
                                </div>
                                <div id="head_index_32" onmouseover="mouseoverchangeclass(32)"
                                     onmouseout="mouseoutchangeclass(32)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(32)">
                                        <img src="../images/pic_head_32_s.gif"></a>
                                </div>
                                <div id="head_index_33" onmouseover="mouseoverchangeclass(33)"
                                     onmouseout="mouseoutchangeclass(33)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(33)">
                                        <img src="../images/pic_head_33_s.gif"></a>
                                </div>
                                <div id="head_index_34" onmouseover="mouseoverchangeclass(34)"
                                     onmouseout="mouseoutchangeclass(34)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(34)">
                                        <img src="../images/pic_head_34_s.gif"></a>
                                </div>
                                <div id="head_index_35" onmouseover="mouseoverchangeclass(35)"
                                     onmouseout="mouseoutchangeclass(35)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(35)">
                                        <img src="../images/pic_head_35_s.gif"></a>
                                </div>
                                <div id="head_index_36" onmouseover="mouseoverchangeclass(36)"
                                     onmouseout="mouseoutchangeclass(36)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(36)">
                                        <img src="../images/pic_head_36_s.gif"></a>
                                </div>
                                <div id="head_index_37" onmouseover="mouseoverchangeclass(37)"
                                     onmouseout="mouseoutchangeclass(37)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(37)">
                                        <img src="../images/pic_head_37_s.gif"></a>
                                </div>
                                <div id="head_index_38" onmouseover="mouseoverchangeclass(38)"
                                     onmouseout="mouseoutchangeclass(38)">
                                    <a onclick="javascript:ChangeClientHeadPhoto(38)" class="mouse_out">
                                        <img src="../images/pic_head_38_s.gif"></a>
                                </div>
                                <div id="head_index_39" onmouseover="mouseoverchangeclass(39)"
                                     onmouseout="mouseoutchangeclass(39)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(39)">
                                        <img src="../images/pic_head_39_s.gif"></a>
                                </div>
                                <div id="head_index_40" onmouseover="mouseoverchangeclass(40)"
                                     onmouseout="mouseoutchangeclass(40)" class="mouse_out">
                                    <a onclick="javascript:ChangeClientHeadPhoto(40)">
                                        <img src="../images/pic_head_40_s.gif"></a>
                                </div>
                            </div>
                            <form  method="post"  enctype="multipart/form-data">
                            <input onclick="Hid(1); saveHead()" name="btnSaveHead" type="button"
                                   id="btnSaveHead" class="save_photo" disabled="disabled" value="保存头像">

                                <input type="hidden" name="hd_value" id="hd_value">

                            <div class="total_ok_pic_green" id="div_update_state" style="display:none">头像已保存！</div>
                            <div class="clear"></div>
                            </form>
                            <p class="go_choice">
                                或从您的电脑中上传图片作为头像
                                <span class="gray_b3">(建议尺寸96*96像素,300以内)></span>
                            </p>
                            <form method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">

                            <div class="browse_mypic">
                                <input type="file" name="file" id="Myfile" size="36" maxlength="30"
                                       onchange="changeSrc(this);addimg()" onclick="div_hidden('div_update_state');"
                                       onkeydown="chkonkeydown(event); "
                                       style="height:25px; width:290px; font-size:12px; padding-top:3px; float:left;">
                                <input type="hidden" name="hid_opt" id="hid_opt">
                                <input onclick="if (!Chkfile()) return false; upload()"
                                       name="btnUpload" type="submit" id="btnUpload" class="browse_button" height="20px"
                                       value="上传" >
                                <div class="total_ok_pic_green2" name="div_upload_state" id="div_upload_state"
                                     style="display: none;"></div>


                                <div class="total_ok_pic_green2" id="headsave2" style="display:none">头像已保存！</div>


                                <div class="loading" id="headsave3" style="display:none">
                                    <img src="../images/loading.gif" title="上传状态中">
                                    <p>上传中...</p>
                                </div>
                                <div class="notice_write1" id="headsave4" style="display:none">图片大小超过300k</div>
                                <img id="imghidden" src="" style="width:0;height:0">
                            </div>
                            </form>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>

              <!-- 编辑资料开始-->
                <form id="form1" method="post" action="${pageContext.request.contextPath}/updatainfo"   enctype="application/x-www-form-urlencoded">

                <div class="edit_message1">
                    <!--输入昵称-->
                    <div class="mesage_list">
                        <div class="list_title">
                            <strong>*</strong>
                            昵称：
                            <input name="v_date" type="hidden" id="v_date" value="">
                        </div>
                        <div class="list_edit">
                            <input type="text" name="custName" id="Text_petname" class="nickname"
                                   onfocus="changeclass(div_1)" onblur="cue_chk()">

                            <span class="c_gray" id="info_1"><p>您的昵称可以由小写英文字母、中文、数字组成，</p>长度4－20个字符，一个汉字为两个字符</span>

                        </div>

                        <div class="empty_box_left"></div>
                </div>

                    <div class="mesage_list">
                        <div class="list_title">
                            <strong>*</strong>
                            性别：
                        </div>

                        <div class="list_edit add_edit_h">
                            <input name="gp_sex" type="radio" id="Rd_sex_1" class="radio_button"
                                   value="0" onclick="changeclass_new('span_1');"
                                   checked="checked">
                            <span class="choice_cont">男</span>
                            <input name="gp_sex" type="radio" id="Rd_sex_2" class="radio_button"
                                   value="1" onclick="changeclass_new('span_1');">
                            <span class="choice_cont">女</span>
                            <div id="notice_3" style="visibility: hidden;"></div>
                        </div>
                        <div class="empty_box_left"></div>
                    </div>


                    <div class="separate_line"></div>

                    <div class="mesage_list">
                        <input type="submit" name="Button1"  onclick="Chksubmit()"  value="保存基本信息" id="Button1" class="save_mess">

                        <div class="total_ok" id="total_ok" style="display: none">基本信息已更新!</div>
                        <div id="stateinfo_info">
                        </div>
                    </div>
                </div>
                </form>

            </div>
        </div>
    </div>

</body>
<jsp:include page="bottom.jsp" flush="true"/>

<script>






    var  get_profile ="${pageContext.request.contextPath}/getprofile;";
    var xhr =null;
    window.onload=function() {
        getprofile();
    }

//从session中获得头像
    function getprofile() {
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP")
        }

        xhr.open("POST", get_profile, true);

        xhr.setRequestHeader( "Content-Type", "application/x-www-form-urlencoded; charset=utf-8");

        xhr.onreadystatechange =loadHead ;
        xhr.send();
    }

    function loadHead() {
            if(xhr.readyState == 4 && xhr.status == 200) {
                var result = xhr.responseText;
                if (result != "") {
                    document.getElementById("img_head_select").src =result;
                } else {

                    alert("请先登录,才能更改信息");
                    window.location = "index";


                }
            }
    }

    var save_url  = "${pageContext.request.contextPath}/saveHead";
        var  img_head_select =document.getElementById("img_head_select");
        var btnSaveHead =document.getElementById("btnSaveHead");


    var xhr =null;
    //保存头像
        function saveHead() {
            if (window.XMLHttpRequest) {
                xhr = new XMLHttpRequest();
            } else {
                xhr = new ActiveXObject("Microsoft.XMLHTTP")
            }
           var custProfile =document.getElementById("img_head_select").src;

            var message = "custProfile=" +custProfile.substring(22);

            // alert(message);

              xhr.open("POST", save_url, true);

            xhr.setRequestHeader( "Content-Type", "application/x-www-form-urlencoded; charset=utf-8");

            xhr.onreadystatechange = showHead;
            xhr.send(message);
    }
    function showHead() {


        if(xhr.readyState == 4 && xhr.status == 200) {
            // alert(xhr.responseText);
            var result = xhr.responseText ;
            // alert(result);
            if(result !=""){

                document.getElementById("img_head_select").src = result;
                document.getElementById("div_update_state").style.display="block";
                alert("保存成功");

            }else{

                alert("请先登录,才能更改信息");
                window.location = "index";
            }
        }

    }
        //添加头像显示预加载
       function addimg() {

             var files = document.getElementById("Myfile").files[0];
             var path=window.URL.createObjectURL(files);
             img_head_select.src =path;
    }




</script>



</html>