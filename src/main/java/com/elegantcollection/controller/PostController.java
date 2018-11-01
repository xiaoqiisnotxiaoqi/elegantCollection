package com.elegantcollection.controller;

import com.elegantcollection.entity.Block;
import com.elegantcollection.entity.Post;
import com.elegantcollection.service.BlockService;
import com.elegantcollection.service.PostService;
import com.elegantcollection.util.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    private final PostService postService;
    private final BlockService blockService;
    PageModel<Post> pageModel = new PageModel<>();

    @Autowired
    public PostController(PostService postService, BlockService blockService) {
        this.postService = postService;
        this.blockService = blockService;
    }

@PostMapping("add")
public String add(@Param("postTitle") String postTitle, @Param("postContext")String postContext, HttpServletRequest request){
    Integer custId=10002;//(Integer) request.getSession().getAttribute("custId");
    Integer blockId=10002;//(Integer) request.getSession().getAttribute("blockId");
        Post post=new Post();
        post.setCustId(custId);
        post.setPostPetname(String.valueOf(blockId));
        post.setPostTitle(postTitle);
        post.setPostText(postContext);
        post.setPostTime(new Date());
        String.valueOf(postService.add(post,request));
        return "post";
}

    /**
     * 获取板块信息
     *
     * @param request blockId 板块id
     * @return 板块对象
     */
    @GetMapping("getBlock")
    HashMap<String, Object> showBlockInfo(HttpServletRequest request) {
        Integer blockId=10002;//(Integer) request.getSession().getAttribute("blockId");
        HashMap<String, Object> hashMap = new HashMap<>();
        Block block = blockService.queryByBlockId(blockId);
        Integer postNumber = postService.queryPostNumber(blockId);
        hashMap.put("block", block);
        hashMap.put("postNumber", postNumber);
        return hashMap;
    }

    /**
     * 获取置顶贴(取5条)
     *
     * @param blockId 板块id
     * @return 置顶帖集合（5条）
     */
    @GetMapping("queryStickPost")
    List<Post> queryStickPost(Integer blockId) {
        blockId=10002;
        return postService.queryStickPost(blockId);
    }

    /**
     * 获取帖子
     *
     * @param request blockId 板块id
     * @return
     */
    @GetMapping("queryPost")
    PageModel<Post> queryPost(HttpServletRequest request, Integer currentPageCode) {
        Integer blockId=10002;//(Integer) request.getSession().getAttribute("blockId");
        initializePageModel(currentPageCode);
        pageModel.setPageSize(10);
        Integer size = postService.queryPost4Size(blockId);
        pageModel.setTotalRecord(size);
        initializeTotalPages(size);
        pageModel = postService.queryPost(blockId, pageModel);
        return pageModel;
    }

    /**
     * 获取精品贴
     *
     * @param request blockId 板块id
     * @return
     */
    @GetMapping("queryBestPost")
    PageModel<Post> queryBestPost(HttpServletRequest request, Integer currentPageCode) {
        Integer blockId=10002;//(Integer) request.getSession().getAttribute("blockId");
        initializePageModel(currentPageCode);
        pageModel.setPageSize(1);
        Integer size = postService.queryBestPost4Size(blockId);
        pageModel.setTotalPages(size);
        initializeTotalPages(size);
        pageModel = postService.queryBestPost(blockId, pageModel);
        return pageModel;
    }

    /**
     * 获取火力贴
     *
     * @return
     */
    @GetMapping("queryBestPopularPost")
    List<Post> queryBestPopularPost() {
        return postService.queryBestPopularPost();
    }


    /**
     * 初始化pageModel
     *
     * @param currentPageCode 当前页数
     */
    private void initializePageModel(Integer currentPageCode) {
        if (currentPageCode == null) {
            currentPageCode = 1;
        }
        pageModel = new PageModel<>();
        pageModel.setCurrentPageCode(currentPageCode);
    }

    /**
     * 初始化页数,开始记录条数
     *
     * @param size 数据总条数
     */
    private void initializeTotalPages(Integer size) {
        if (size % pageModel.getPageSize() != 0) {
            pageModel.setTotalPages(size / pageModel.getPageSize() + 1);
        } else {
            pageModel.setTotalPages(size / pageModel.getPageSize());
        }
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
    }

}
