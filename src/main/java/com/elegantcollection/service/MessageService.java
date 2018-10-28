package com.elegantcollection.service;

import com.elegantcollection.entity.Message;

import java.util.List;
import java.util.Map;

public interface MessageService {

    /**
     *根据用户的id 查找该用户未查看的 消息
     * @param recipientsId 用户id(收信人id)
     * @return 消息对象
     */
    List<Message> quaryByRecipientsId(Integer recipientsId);


    /**
     * 根据收信人id 查看该收信人 共有多少条消息为查看
     * @param recipientsId 收信人id
     * @return 没有查看得消息的数量
     */
    Long quaryNumByRecipientsId(Integer recipientsId);

    /**
     * 根据用户的id  分页查找该用户未查看的 消息
     * @param custId 被回复人id
     * @param pageSize 每页显示的数据量
     * @param startRecord 本页开始显示数据的条数
     * @return 消息对象
     */
    List<Message> quaryMessageByPage(Integer custId,Integer pageSize,Integer startRecord);


}
