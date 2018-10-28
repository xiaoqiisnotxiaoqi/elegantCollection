var allUrl = null;

var xhr = null;
var xhr0 = null;
var xhr1 = null;
var xhr2 = null;
var xhr3 =null;
onload = function () {
    refreblock();
    refreshStickPost();
    refreshPost(1);
    refreshBestPopularPost();
}
//板块信息
var blockBackground = document.getElementById("block-background");
var blockImage = document.getElementById("block-image");
var blockName = document.getElementById("block-name");
var blockInfo = document.getElementById("block-info");
var postsNumber = document.getElementById("posts-number");
//置顶帖
var popularPosts = document.getElementById("popular-posts")
//普通贴
var timePosts = document.getElementById("time-posts")
//火力贴
var allPopularPosts = document.getElementById("all-popular-posts");
//页面按钮
var paginationBtns = document.getElementById("pagination-btns");
//发表帖子
var postButton=document.getElementById("post-button");
postButton.addEventListener("click",function () {
    allUrl = "/post/add";
    refreshblockDate(allUrl);
})
var columns = document.getElementById("columns");
for (var i = 1; i < columns.childNodes.length; i = i + 2) {
    columns.childNodes[i].onclick = function () {
        removeOther();
        this.style.backgroundColor = "rgb(225, 225, 225)";
    }
}

function removeOther() {
    for (var i = 1; i < columns.childNodes.length; i = i + 2) {
        columns.childNodes[i].style.backgroundColor = "rgb(235, 235, 235)";
    }
}

function refreblock() {
    allUrl = "/post/getBlock";
    refreshblockDate(allUrl);
}

function refreshblockDate(url) {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr != null) {
        xhr.open("GET", url, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr.onreadystatechange = getblockDate;
        xhr.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
}

function getblockDate() {
    if (xhr.readyState === 4 && xhr.status === 200) {
        var jsonText = JSON.parse(xhr.responseText);
        var block = jsonText.block;
        blockName.innerText = block.blockName;
        blockInfo.innerText = block.blockInfo;
        blockBackground.src = block.blockBackground;
        blockImage.src = block.blockIma;
        postsNumber.innerHTML = jsonText.postNumber
    } else {
        // alert("xhr.readyState = " + xhr.readyState + ", xhr.status =  " + xhr.status)
    }
}

function refreshStickPost() {
    allUrl = "/post/queryStickPost";
    refreshStickPostDate(allUrl);
}

function refreshStickPostDate(url) {
    if (window.XMLHttpRequest) {
        xhr0 = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr0 = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr0 != null) {
        xhr0.open("GET", url, true);
        xhr0.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr0.onreadystatechange = getStickPost;
        xhr0.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
}

function getStickPost() {
    if (xhr0.readyState === 4 && xhr0.status === 200) {
        var jsonText = JSON.parse(xhr0.responseText);
        var stickPostList = jsonText;
        for (var i = 0; i < stickPostList.length; i++) {
            popularPosts.innerHTML += "<div class=\"popular-post\"><div class=\"reply-number\">" + stickPostList[i].replyCount + "</div><div class=\"post-all\"><a href=\"#\">" + stickPostList[i].postTitle + "</a><span class=\"post-text\">" + stickPostList[i].postText + "</span></div></div>\n"
        }
    } else {
        // alert("xhr0.readyState = " + xhr0.readyState + ", xhr0.status =  " + xhr0.status)
    }
}

function refreshBestPost(currentPageCode) {
    allUrl = "/post/queryBestPost?currentPageCode=" + currentPageCode;
    refreshBestPostDate(allUrl);
}

function refreshBestPostDate(url) {
    if (window.XMLHttpRequest) {
        xhr3 = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr3 = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr3 != null) {
        xhr3.open("GET", url, true);
        xhr3.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr3.onreadystatechange = getBestPostDate;
        xhr3.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
}

function getBestPostDate() {
    if (xhr3.readyState === 4 && xhr3.status === 200) {
        var jsonText = JSON.parse(xhr3.responseText);
        var postList = jsonText.modelList;
        popularPosts.innerHTML=null;
        timePosts.innerHTML = null;
        paginationBtns.innerHTML = null;
        for (i = 0; i < postList.length; i++) {
            timePosts.innerHTML += "<div class=\"time-post\"><div class=\"reply-number\">" + postList[i].replyCount + "</div><div class=\"post-all\"><a href=\"#\">" + postList[i].postTitle + "</a><span class=\"post-text\">" + postList[i].postText + "</span></div></div>\n"
        }
        var totalPages = jsonText.totalPages;
        var currentPageCode = jsonText.currentPageCode;
        if (totalPages < 10) {
            for (var j = 1; j <= totalPages; j++) {
                if (currentPageCode == j) {
                    paginationBtns.innerHTML += " <input type=\"button\" class=\"now-pagination-btn\"value=\"" + j + "\">"
                } else {
                    paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshBestPost(" + j + ")' value=\"" + j + "\">"
                }
            }
        } else {
            if (currentPageCode >= 5 && totalPages - currentPageCode >= 5) {
                paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshBestPost(" + 1 + ")' value=\"首页\">"
                for (var k = currentPageCode - 5; k < currentPageCode + 5; k++) {
                    if (currentPageCode == k) {
                        paginationBtns.innerHTML += " <input type=\"button\" class=\"now-pagination-btn\"value=\"" + k + "\">"
                    } else {
                        paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshBestPost(" + k + ")' value=\"" + k + "\">"
                    }
                }
                paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshBestPost(" + totalPages + ")' value=\"尾页\">"
            } else if (currentPageCode < 5) {
                for (var p = currentPageCode; p <= 10; p++) {
                    if (currentPageCode == p) {
                        paginationBtns.innerHTML += " <input type=\"button\" class=\"now-pagination-btn\"value=\"" + p + "\">"
                    } else {
                        paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshBestPost(" + p + ")' value=\"" + p + "\">"
                    }
                }
                paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshBestPost(" + totalPages + ")' value=\"尾页\">"
            } else if (totalPages - currentPageCode < 5) {
                paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshBestPost(" + 1 + ")' value=\"首页\">"
                for (var q = totalPages - 9; q <= totalPages; q++) {
                    if (currentPageCode == q) {
                        paginationBtns.innerHTML += " <input type=\"button\" class=\"now-pagination-btn\"value=\"" + q + "\">"
                    } else {
                        paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshBestPost(" + q + ")' value=\"" + q + "\">"
                    }
                }

            }
        }
    } else {
        //alert("xhr3.readyState = " + xhr3.readyState + ", xhr3.status =  " + xhr3.status)
    }
}

function refreshPost(currentPageCode) {
    allUrl = "/post/queryPost?currentPageCode=" + currentPageCode;
    refreshPostDate(allUrl);
}

function refreshPostDate(url) {
    if (window.XMLHttpRequest) {
        xhr1 = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr1 = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr1 != null) {
        xhr1.open("GET", url, true);
        xhr1.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr1.onreadystatechange = getPostDate;
        xhr1.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
}

function getPostDate() {
    if (xhr1.readyState === 4 && xhr1.status === 200) {
        var jsonText = JSON.parse(xhr1.responseText);
        var postList = jsonText.modelList;
        timePosts.innerHTML = null;
        paginationBtns.innerHTML = null;
        for (i = 0; i < postList.length; i++) {
            timePosts.innerHTML += "<div class=\"time-post\"><div class=\"reply-number\">" + postList[i].replyCount + "</div><div class=\"post-all\"><a href=\"#\">" + postList[i].postTitle + "</a><span class=\"post-text\">" + postList[i].postText + "</span></div></div>\n"
        }
        var totalPages = jsonText.totalPages;
        var currentPageCode = jsonText.currentPageCode;
        if (totalPages < 10) {
            for (var j = 1; j <= totalPages; j++) {
                if (currentPageCode == j) {
                    paginationBtns.innerHTML += " <input type=\"button\" class=\"now-pagination-btn\"value=\"" + j + "\">"
                } else {
                    paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshPost(" + j + ")' value=\"" + j + "\">"
                }
            }
        } else {
            if (currentPageCode >= 5 && totalPages - currentPageCode >= 5) {
                paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshPost(" + 1 + ")' value=\"首页\">"
                for (var k = currentPageCode - 5; k < currentPageCode + 5; k++) {
                    if (currentPageCode == k) {
                        paginationBtns.innerHTML += " <input type=\"button\" class=\"now-pagination-btn\"value=\"" + k + "\">"
                    } else {
                        paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshPost(" + k + ")' value=\"" + k + "\">"
                    }
                }
                paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshPost(" + totalPages + ")' value=\"尾页\">"
            } else if (currentPageCode < 5) {
                for (var p = currentPageCode; p <= 10; p++) {
                    if (currentPageCode == p) {
                        paginationBtns.innerHTML += " <input type=\"button\" class=\"now-pagination-btn\"value=\"" + p + "\">"
                    } else {
                        paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshPost(" + p + ")' value=\"" + p + "\">"
                    }
                }
                paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshPost(" + totalPages + ")' value=\"尾页\">"
            } else if (totalPages - currentPageCode < 5) {
                paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshPost(" + 1 + ")' value=\"首页\">"
                for (var q = totalPages - 9; q <= totalPages; q++) {
                    if (currentPageCode == q) {
                        paginationBtns.innerHTML += " <input type=\"button\" class=\"now-pagination-btn\"value=\"" + q + "\">"
                    } else {
                        paginationBtns.innerHTML += " <input type=\"button\" class=\"pagination-btn\" onclick='refreshPost(" + q + ")' value=\"" + q + "\">"
                    }
                }

            }
        }
    } else {
        //alert("xhr1.readyState = " + xhr1.readyState + ", xhr1.status =  " + xhr1.status)
    }
}

function refreshBestPopularPost() {
    allUrl = "/post/queryBestPopularPost";
    refreshBestPopularPostDate(allUrl);
}

function refreshBestPopularPostDate(url) {
    if (window.XMLHttpRequest) {
        xhr2 = new XMLHttpRequest(); //for ie7+,FireFox,Chorme,Opera,Safai...
    } else {
        xhr2 = new ActiveXObject('Microsoft.XMLHTTP');//for ie6
    }

    if (xhr2 != null) {
        xhr2.open("GET", url, true);
        xhr2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
        xhr2.onreadystatechange = getBestPopularPostDate;
        xhr2.send();
    } else {
        alert("不能创建XMLHttpRequest对象实例");
    }
}

function getBestPopularPostDate() {
    if (xhr2.readyState === 4 && xhr2.status === 200) {
        var jsonText = JSON.parse(xhr2.responseText);
        var BestPopularPostList = jsonText;
        for (var i = 0; i < BestPopularPostList.length; i++) {
            var postNo = i + 1;
            allPopularPosts.innerHTML += "<div class=\"all-popular-post\"><a href=\"www.baidu.com\">" + "<div class='all-popular-post-tip'>" + postNo + "</div>" + BestPopularPostList[i].postTitle + "</a></div>";
        }
    } else {
        //alert("xhr2.readyState = " + xhr2.readyState + ", xhr2.status =  " + xhr2.status)
    }
}