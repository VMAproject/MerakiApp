package com.meraki.dao.impls;

import com.meraki.dao.interfaces.BlackBookDao;
import com.meraki.entity.BlackBook;
import com.meraki.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Verlamov on 20.03.17.
 */
@Repository
public class BlackBookDaoImpl implements BlackBookDao {

    private static final Logger logger = LoggerFactory.getLogger(BlackBookDaoImpl.class);


    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createBlackBook(BlackBook blackBook) {
        return (Long) hibernateUtil.create(blackBook);
    }

    @Override
    public BlackBook updateBlackBook(BlackBook blackBook) {
        return hibernateUtil.update(blackBook);
    }

    @Override
    public void deleteBlackBook(long id) {
        BlackBook blackBook = new BlackBook();
        blackBook.setId(id);
        hibernateUtil.delete(blackBook);

    }

    @Override
    public List<BlackBook> getAllBlackBooks() {
        return hibernateUtil.fetchAll(BlackBook.class);
    }

    @Override
    public BlackBook getBlackBook(long id) {
        return hibernateUtil.fetchById(id, BlackBook.class);
    }
}
