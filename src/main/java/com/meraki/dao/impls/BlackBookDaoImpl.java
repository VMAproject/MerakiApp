package com.meraki.dao.impls;

import com.meraki.dao.interfaces.BlackBookDao;
import com.meraki.entity.BlackBook;
import com.meraki.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlackBookDaoImpl implements BlackBookDao {

    private static final Logger logger = LoggerFactory.getLogger(BlackBookDaoImpl.class);


    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createBlackBook(BlackBook blackBook) {
        logger.info("*** Black Book Dao *** create Black Book =>" + blackBook);
        return (Long) hibernateUtil.create(blackBook);
    }

    @Override
    public BlackBook updateBlackBook(BlackBook blackBook) {
        logger.info("*** Black Book Dao *** update Black Book  =>" + blackBook);
        return hibernateUtil.update(blackBook);
    }

    @Override
    public void deleteBlackBook(long id) {
        BlackBook blackBook = new BlackBook();
        blackBook.setId(id);
        logger.info("*** Black Book Dao *** delete Black Book for ID =>" + id);
        hibernateUtil.delete(blackBook);

    }

    @Override
    public List<BlackBook> getAllBlackBooks() {
        logger.info("*** Black Book Dao *** get All Black Books =>" + BlackBook.class);
        return hibernateUtil.fetchAll(BlackBook.class);
    }

    @Override
    public BlackBook getBlackBook(long id) {
        logger.info("*** Black Book Dao *** get Black Book =>" + id + BlackBook.class);
        return hibernateUtil.fetchById(id, BlackBook.class);
    }
}
