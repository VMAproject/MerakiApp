package com.meraki.dao.interfaces;

import com.meraki.entity.BlackBook;

import java.util.List;


public interface BlackBookDao {

    long createBlackBook(BlackBook blackBook);

    BlackBook updateBlackBook(BlackBook blackBook);

    void deleteBlackBook(long id);

    List<BlackBook> getAllBlackBooks();

    BlackBook getBlackBook(long id);


}
