// var survey_url="http://my.dangdang.com/myhome/DocPersonalMenu.aspx";
//
// function showDocSetPage()
// {
//     var lin =  document.getElementById("tag_box1");
//
//     lin.innerHTML = doc_show_window(survey_url);
//
//     new dragObject(lin, "handle", null, null, null, null, null, false);
//     var pos = getPosition(document.getElementById("DocPersonal_set"));
//     lin.style.left= pos.x +80 + "px";
//     lin.style.top = pos.y -10 + "px";
//
//     lin.style.display="block";
//
// }
function ShowHeadPhotoType(o) {

}


/***
 *功能：隐藏和显示div
 *参数divDisplay：html标签id
 ***/
function click_a(changecss, divDisplay) {

    if (document.getElementById(divDisplay).style.display != "block") {
        document.getElementById(changecss).className = "slide_up";
        document.getElementById(divDisplay).style.display = "block";
    }
    else {

        document.getElementById(divDisplay).style.display = "none";
        document.getElementById(changecss).className = "slide_down";
    }
}

/**
 *  显示头像的div轮换
 * @param id 传入的参数
 * @constructor
 */

function ShowHeadPhotoType(id) {

    var obj_type_id = document.getElementById("hiddenphototypeid");
    for (var i = 0; i < 4; i++) {
        var obj_head = document.getElementById("head_type_" + i);
        var obj_photo = document.getElementById("all_photo_" + i);

        if (obj_head != null && obj_photo != null) {
            if (i == id) {
                obj_head.className = "all_photo_title_mo";
                // obj_head.setAttribute("className","all_photo_title_mo");
                obj_photo.style.display = "block";
            }
            else {
                obj_head.className = "all_photo_title_other";
                // obj_head.setAttribute("className","all_photo_title_other");
                obj_photo.style.display = "none";
            }
        }
    }
    if (obj_type_id != null)
        obj_type_id.value = id;
    if (id < 0 || id > 3) {
        if (obj_type_id != null)
            obj_type_id.value = 0;
    }

}

function ChangeClientHeadPhoto(index)
{
    if(index <1 ||index > 40)
        return ;
    var head_img = document.getElementById("img_head_select");
    var head_index = document.getElementById("hinddenimgindex");
    if(head_index != null)
    {
        if(head_index.value == index)
            return;
    }
    var head_select ;
    for(var i=1;i<=40;i++)
    {
        head_select = document.getElementById("head_index_"+i);
        if(head_select != null)
        {
            if(i==index)
            {
                head_select.className ="mouse_active";

            }
            else
            {
                head_select.className ="";
            }
        }
    }
    if(head_index != null)
    {
        head_index.value=index;
    }
    if(head_img != null)
    {
        head_img.src = "../images/pic_head_"+index+"_s.gif";
    }
    var objbtn = document.getElementById("btnSaveHead");
    if(objbtn != null)
    {
        objbtn.disabled = false;
    }
    var objbtn1 = document.getElementById("btnUpload");
    if(objbtn1 != null)
    {
        objbtn1.disabled = true;
    }
    var hd_value = document.getElementById("hd_value");
    if(hd_value != null)
    {
        hd_value.value = index;
    }

    var savestate = document.getElementById("div_upload_state");
    if(savestate != null)
    {
        savestate.style.display="none";
    }

    var uploadstate = document.getElementById("div_update_state");
    if(uploadstate != null)
    {
        uploadstate.style.display="none";
    }
}


function mouseoverchangeclass(index) {
    if (index < 1 || index > 40) {
        return;
    }

    var obj = document.getElementById("head_index_" + index)
    if (obj != null) {
        if (obj.className != "mouse_active")
            obj.className = "mouse_over";
    }
}

function mouseoutchangeclass(index) {
    if (index < 1 || index > 40) {
        return;
    }
    var obj = document.getElementById("head_index_" + index)
    if (obj != null) {
        if (obj.className != "mouse_active")
            obj.className = "mouse_out";
    }
}


var imgstate=0;
function Hid(i)
{
    var obj = document.getElementById('hid_opt');
    if (obj==null)
    {return;}
    else
    {
        obj.value = i;
    }
}


function Chkfile()
{
    Hid(0);
    var hid_opt=document.getElementById("hid_opt");
    if (hid_opt.value=="1"){
        ShowHidDIV('div_upload_state');
        return true;
        //document.form1.submit();
    }
    var objfile=document.getElementById("Myfile");

    if (objfile.value=="")
    {
        //div_upload_state_opt("请先从您的电脑中选择一个图片文件","notice_choice");
        div_upload_state_opt("请先选择图片文件","notice_write1");
        return false;
    }
    else
    {

        if (!ChkFileExist(objfile.value)){
            div_upload_state_opt("图片不存在，请重新选择图片");
        }
        else{
            if (Check_FileType(objfile.value))
            {
                if (this.checkSize())
                {
                    ShowHidDIV('div_upload_state');
                    return true;
                    //document.form1.submit();
                }
                else
                {
                    //alert("图片好大-_-! 请不要使用大于1M的图片");
                    div_upload_state_opt("图片大小超过300k","notice_write1");
                    return false;
                }
            }
            else{
                //div_upload_state_opt("您上传的图片必须为jpg,gif,bmp,png类型","notice_write1");
                div_upload_state_opt("仅支持jpg,gif,png,bmp格式","notice_write1");
                return false;
            }
        }


    }
}



function ShowHidDIV(divname)
{
    var fileobj = document.getElementById('Myfile');
    var h_upload_state = document.getElementById('h_upload_state');
    if (h_upload_state) h_upload_state.value=1;
    div_upload_state_opt('<img src="../images/loading.gif" title="上传状态中" /><p>上传中...</p>','loading');
}

function div_upload_state_opt(str,classname)
{
    var obj = document.getElementById("div_upload_state");
    obj.innerHTML = str;
    obj.className = classname;
    //obj.style.visibility='visible';
    obj.style.display = "block";
}

function ChkFileExist(filepath)
{
    return true;
}


function Check_FileType(str)
{
    var pos = str.lastIndexOf(".");
    var lastname = str.substring(pos,str.length)  //此处文件后缀名也可用数组方式获得str.split(".")
    if (lastname.toLowerCase()!=".jpg" && lastname.toLowerCase()!=".gif"&& lastname.toLowerCase()!=".bmp"&& lastname.toLowerCase()!=".png")
    {
        return false;
    }
    else
    {
        var btnupload = document.getElementById("btnUpload");
        btnupload.disabled=false;
        return true;
    }
}

function checkSize()
{

    var limitnum=300;
    var limit  = limitnum * 1024;
    var objfile=document.getElementById("imghidden");
    //alert(objfile.fileSize);
    if (objfile.fileSize > limit)
    {
        var objfile=document.getElementById("imghidden");
        if(objfile){
            objfile.src="";
        }
        return false;
    }
    else
    {
        return true;
    }
}



function changeSrc(filePicker)
{
    this.div_hidden('div_update_state');
    this.div_hidden('div_upload_state');
    var oFileChecker = document.getElementById("imghidden");

    if (this.Check_FileType(filePicker.value))
        oFileChecker.src = filePicker.value;
    //oFileChecker.src = "file:/// "   +   filePicker.value.replace(/\\/g, "/ ") ;
    else
    {
        //alert("您上传的图片必须为.jpg,.gif,.bmp,png类型");
        div_upload_state_opt("仅支持jpg,gif,png,bmp格式","notice_write1");
        var btnupload = document.getElementById("btnUpload");
        btnupload.disabled=true;

    }

}


function div_hidden(divname){

    var div = document.getElementById(divname);
    if(!div)
        return;
    if (div.innerHTML!="")
        div.innerText="";
    //div.style.visibility='hidden';
    div.style.display="none";


    var Button2 = document.getElementById("btnSaveHead");
       Button2.disabled="true";

}

if(navigator.userAgent.indexOf("Firefox")>0){
    IniHidDiv();
    CheckForm();
}
else if (navigator.userAgent.indexOf("MSIE")>0){
    IniHidDiv();
    CheckForm();
}

function cue_chk(){

    var obj = document.getElementById("Text_petname");
    var info = document.getElementById("info_1");
    var reg = /^\d+$/g;
    var reg1 = /[A-Z]/g;
    if (obj!=null && info!=null)
    {
        if (GetCharLength(obj.value)<4){
            info.className = "notice_write";
            info.innerHTML="最少四个字符，请输入您的昵称";
            return false;
        }else if(reg.test(obj.value)){

            info.className = "notice_write";
            info.innerHTML="昵称不能全由数字组成！";
            return false;
        }else if(reg1.test(obj.value)){

            info.className = "notice_write";
            info.innerHTML="昵称不能有大写字母！";
            return false;
        }
        else{

            if (ChkNickname_new()){
                var v_date = document.getElementById("v_date");
                if (v_date!=null){
                    var v_date_value = v_date.value;
                    info = null;
                    chknickname(v_date_value,obj.value);

                }
                return true;
            }
        }
    }
}

function ChkNickname_new(){

    var info = document.getElementById("info_1");
    var obj = document.getElementById("Txt_petname");
    var username = obj.value;
    var reg = /^(\w|[\u4E00-\u9FA5])*$/;
    if(arr=username.match(reg))
    {
        return true;
    }
    else
    {
        info.className = "notice_write";
        //obj.focus();
        info.innerHTML="昵称只能是数字，字母和汉字";
        return false;
    }
}


function chkonkeydown(evt){
    if(navigator.userAgent.indexOf("Firefox")>0){
        evt = evt ? evt : (window.event ? window.event : null);
        evt.preventDefault();
        evt.stopPropagation();

    }
    else if (navigator.userAgent.indexOf("MSIE")>0){
        event.returnValue = false;
        event.cancelBubble = true;
    }
}









function GetCharLength(str)
{
    var iLength = 0;
    for(var i = 0;i<str.length;i++)
    {
        if(str.charCodeAt(i) >255)
        {
            iLength += 2;
        }
        else
        {
            iLength += 1;
        }
    }
    return iLength;
}


function changeclass_new(name){
    var obj1 = document.getElementById(name+"_1");
    var obj2 = document.getElementById(name+"_2");
    if(obj1)
        obj1.className = "choice_cont now_color";
    if(obj2)
        obj2.className = "choice_cont now_color choice_cont_r";
}






