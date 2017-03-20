package com.meraki.service.impl;

import com.meraki.dao.BlackBookDao;
import com.meraki.entity.BlackBook;
import com.meraki.service.BlackBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Verlamov on 20.03.17.
 */

@Service
@Transactional
public class BlackBookServiceImpl implements BlackBookService {


    @Autowired
    private BlackBookDao blackBookDao;


    @Override
    public long createBlackBook(BlackBook blackBook) {
        return blackBookDao.createBlackBook(blackBook);
    }

    @Override
    public BlackBook updateBlackBook(BlackBook blackBook) {
        return blackBookDao.updateBlackBook(blackBook);
    }

    @Override
    public void deleteBlackBook(long id) {
        blackBookDao.deleteBlackBook(id);
    }

    @Override
    public List<BlackBook> getAllBlackBooks() {
        return blackBookDao.getAllBlackBooks();
    }

    @Override
    public BlackBook getBlackBook(long id) {
        return blackBookDao.getBlackBook(id);
    }
}
