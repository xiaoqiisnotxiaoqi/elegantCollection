package com.elegantcollection.service.impl;

import com.elegantcollection.dao.MessageDao;
import com.elegantcollection.entity.Message;
import com.elegantcollection.entity.MessageExample;
import com.elegantcollection.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageServiceImpl implements MessageService{
    private final MessageDao messageDao;

    @Autowired
    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public List<Message> quaryByRecipientsId(Integer recipientsId) {
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andRecipientsIdEqualTo(recipientsId).andReadStatusEqualTo(0);
        return  messageDao.selectByExample(messageExample);
    }

    @Override
    public Long quaryNumByRecipientsId(Integer recipientsId) {
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andRecipientsIdEqualTo(recipientsId).andReadStatusEqualTo(0);
        return  messageDao.countByExample(messageExample);
    }

    @Override
    public List<Message> quaryMessageByPage(Integer custId,Integer pageSize,Integer startRecord) {
        MessageExample messageExample = new MessageExample();
        messageExample.setLimit(pageSize);
        messageExample.setOffset(startRecord.longValue());
        messageExample.createCriteria().andRecipientsIdEqualTo(custId).andReadStatusEqualTo(0);
        return messageDao.selectByExample(messageExample);
    }
}
