window.onload = function () {
    var container = document.getElementById('container')//获取容器id
    var list = document.getElementById('list')//获取img容器
    var buttons = document.getElementById('buttons').getElementsByTagName('span')//获取点
    var prev = document.getElementById('prev')//左按钮
    var next = document.getElementById('next')//右按钮
    var animated = false
    var index = 1;//小圆点
    var timer;//定时器

    //小圆点
    function showButton() {
        //对点点循环，去除已经有的on
        for (var i = 0; i < buttons.length; i++) {
            if (buttons[i].className == 'on') {
                buttons[i].className = ''
                break//退出循环
            }
        }
        buttons[index - 1].className = 'on'
    }

    function animate(offset) {
//            快速点击时，会出现小圆点和图片不对应的情况，解决方案是当图片处于动画状态时，直接屏蔽掉点击事件
        animated = true// 快速点击时，会出现小圆点和图片不对应的情况，解决方案是当图片处于动画状态时，直接屏蔽掉点击事件
        var newLeft = parseInt(list.style.left) + offset

        //焦点图轮播
        var time = 300;//位移总时间
        var interval = 10;//位移间隔时间
        var speed = offset / (time / interval)//每次位移量
        function go() {
            if (speed < 0 && parseInt(list.style.left) > newLeft || (speed > 0 && parseInt(list.style.left) < newLeft)) {
                list.style.left = parseInt(list.style.left) + speed + 'px'
                setTimeout(go, interval)
            } else {
                animated = false;// 快速点击时，会出现小圆点和图片不对应的情况，解决方案是当图片处于动画状态时，直接屏蔽掉点击事件
                list.style.left = newLeft + 'px' //转成数字600
                //判断是否l滚动到辅助图,图片滚动在-600和-3000之间,解决空白问题
                if (newLeft > -750) {
                    list.style.left = -3000 + 'px'
                }
                if (newLeft < -3000) {
                    list.style.left = -750 + 'px'
                }
            }
        }

        go();

    }

    //自动切换
    function play() {
        timer = setInterval(function () {
            next.onclick()
        }, 3000);
    }

    //停止切换
    function stop() {
        clearInterval(timer)
    }

    //右箭头
    next.onclick = function () {
        //判断点点是否是最后一个或者第一个
        /*            if(index==5){
                        index=1;
                    }else{
                        index+=1;
                    }*/
        index += 1;
        index = index > 5 ? 1 : index;
        showButton()
        //+600和-600当做参数传给animate
//            list.style.left=parseInt(list.style.left)-600 +'px' //把字符串变为整数值，paresInt()只保留字符串中的数字
        if (!animated) {
            animate(-750)
        }
    }
    //左箭头
    prev.onclick = function () {
        /* if(index==1){
             index=5;
         }else{
             index-=1;
         }*/
        index -= 1;
        index = index < 1 ? 5 : index;
        showButton()
//            list.style.left=parseInt(list.style.left)+600+'px'
        if (!animated) {
            animate(750)
        }
    }
    //小圆点加事件
    for (var i = 0; i < buttons.length; i++) {
        buttons[i].onclick = function () {
//                if(this.className=='on'){
//                    return;
//                }
            var myIndex = parseInt(this.getAttribute('index'))//获取当前点点的index
            var offset = -750 * (myIndex - index) //移动的距离：当前的index-之前的index
            //恢复小圆点位置
            index = myIndex
            showButton()
            if (!animate) {
                animate(offset)
            }
        }
    }
    //鼠标移上去，触发自动切换事件
    container.onmouseover = stop;//不要加括号，
    container.onmouseout = play
    //自动切换
    play();
    indexData();

}

//点击分类,跳转
function clickCate(ele) {
    sessionStorage.setItem("categoryId", ele.firstChild.name);
    window.location = "allbooks";

}

//    渲染首页数据
function indexData() {
    var xhr = null;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    }
    else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }
    if (xhr != null) {
        xhr.open("GET", "book/index", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr.onreadystatechange = callFun;
        xhr.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }

    function callFun() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText);
            var jsObj = JSON.parse(xhr.responseText);

            // 渲染新书上架数据
            var classList = document.getElementsByClassName("col-md-3");
            var newBookList = jsObj.data.bookList0;
            var newBookAuthors = jsObj.data.newBookAuthors;
            for (let i = 0; i < 16; i++) {
                classList[i].innerHTML = "  <a href=\"bookdetail/?bookId=" + newBookList[i].bookId + "\"> <img src=\"" + newBookList[i].bookImg + " \"width=150px height=150px>\n" +
                    "                    <div class=\"new-title-word\">" + newBookList[i].bookName + "</div>\n</a>" +
                    "                    <div class=\"new-author\">" + newBookAuthors[i].authorName + "</div>\n" +
                    "                    <div class=\"cost-price-icon\">¥</div>\n" +
                    "                    <div class=\"cost-price\">" + newBookList[i].bookSellingPrice + "</div>\n" +
                    "                    <div class=\"original-price-icon\">¥</div>\n" +
                    "                    <div class=\"original-price\">" + newBookList[i].bookMarkedPrice + "</div> ";
            }


            //    渲染总榜
            writeData(document.getElementById("all"), jsObj.data.bookList1);
            //    渲染其他榜
            writeData(document.getElementById("childbook1"), jsObj.data.bookList2);
            writeData(document.getElementById("childbook2"), jsObj.data.bookList3);
            writeData(document.getElementById("childbook3"), jsObj.data.bookList4);
            writeData(document.getElementById("childbook4"), jsObj.data.bookList5);

            //渲染作者
            var authorList = jsObj.data.authorList;
            document.getElementById("first-author").innerHTML = "<div class=\"col-md-1\">\n" +
                "            <div class=\"num-1\">1</div>\n" +
                "            <div class=\"num-st\">st</div>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-2 hot-author-img\">\n" +
                "            <img src=\"" + authorList[0].authorImg + "\" alt=\"\">\n" +
                "        </div>\n" +
                "        <div class=\"col-md-8\">\n" +
                "            <div class=\"row\" >\n" +
                "                <div class=\"col-md-12 author-name\">\n" +
                "                    " + authorList[0].authorName + "\n" +
                "                </div>\n" +
                "                <div class=\"col-md-12\">\n" +
                "                    <div class=\"author-content\">\n" +
                "                        <p class=\"author-content-p\">" + authorList[0].authorIntro + "</p>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>";
            var anthorBookList = jsObj.data.anthorBookList;
            document.getElementById("first-author-books").innerHTML = "";
            for (var i = 0; i < anthorBookList.length; i++) {
                document.getElementById("first-author-books").innerHTML += "<div class=\"col-lg-3\">\n" +
                    "        <a href=\"bookdetail/?bookId=" + anthorBookList[i].bookId + "\">\n" +
                    "        <img src=\"" + anthorBookList[i].bookImg + "\" width='150px' height='150px'>\n" +
                    "        <div class=\"work-title\">" + anthorBookList[i].bookName + "</div></a>\n" +
                    "        <div class=\"work-cost-icon\">￥</div>\n" +
                    "        <div class=\"work-cost-price\">" + anthorBookList[i].bookSellingPrice + "</div>\n" +
                    "        <div class=\"work-original-icon\">￥</div>\n" +
                    "        <div class=\"work-original-price\">" + anthorBookList[i].bookMarkedPrice + "</div>\n" +
                    "    </a>";
            }

            for (var i = 0; i < authorList.length; i++) {
                document.getElementById("author-sort").innerHTML += "<div class=\"col-md-12 author-sort-content\">\n" +
                    "        <div class=\"author-sort-num\">" + (i + 1) + "</div>\n" +
                    "        <div class=\"author-sort-name\">" + authorList[i].authorName + "</div>\n" +
                    "    </div>";
            }


            //    渲染仨书单
            document.getElementById("orders").innerHTML = "";
            var orders = jsObj.data.bookOrders;
            for (var i = 0; i < orders.length; i++) {
                document.getElementById("orders").innerHTML += "<div class=\"col-lg-4 book-order-content\">\n" +
                    "        <img src=\"" + orders[i].orderImg + "\"  onclick= \"clickOrder(" + orders[i].orderId + ")\">\n" +
                    "    </div>";
            }

        }

    }
}


/**
 *
 */
function writeData(ele, bookList) {

    ele.innerHTML = "";
    //渲染排行第一的数据
    ele.innerHTML += "<div class=\"row hot-infor\">\n" +
        "                    <div class=\"col-md-1 hot-num\">\n" +
        "                        1\n" +
        "                    </div>\n" +
        "                    <div class=\"col-md-5 hot-img\">\n" +
        "                        <img src=\"" + bookList[0].bookImg + "\" alt=\"\">\n" +
        "                    </div>\n" +
        "                    <div class=\"col-md-4\">\n" +
        "                        <div class=\"hot-book-name\"><a href=\"/bookdetail/?bookId=" + bookList[0].bookId + "\">" + bookList[0].bookName + "</a></div>\n" +
        "                        <div class=\"hot-cost-price-icon\">￥</div>\n" +
        "                        <div class=\"hot-cost-price\">" + bookList[0].bookSellingPrice + "</div>\n" +
        "                        <div class=\"hot-original-price-icon\">￥</div>\n" +
        "                        <div class=\"hot-original-price\">" + bookList[0].bookSellingPrice + "</div>\n" +
        "                        <div class=\"hot-comment\">\n" +
        "                            <a href=\"\">10</a>\n" +
        "                            <div>条评论</div>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"hot-xian\"></div>\n" +
        "                </div>";
    //渲染2-10的数据
    for (var i = 1; i < bookList.length; i++) {
        var bookName = bookList[i].bookName;
        if (bookList[i].bookName.length > 16) {
            bookName = bookList[i].bookName.substring(0, 16);
        }
        ele.innerHTML += "<div class=\"row hot-normal\">\n" +
            "                    <div class=\" col-md-1 hot-normal-num\">" + (i + 1) + "</div>\n" +
            "                    <a href=\"/bookdetail/?bookId=" + bookList[i].bookId + "\">" + bookName + "</a>\n" +
            "                    <div class=\"hot-normal-xian\"></div>\n" +
            "                </div>";
    }

}

function clickOrder(ele) {
    window.location = "/booklist/?orderId=" + ele;

}

