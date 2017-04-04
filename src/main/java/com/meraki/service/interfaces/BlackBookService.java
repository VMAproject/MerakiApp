package com.meraki.service.interfaces;

import com.meraki.entity.BlackBook;

import java.util.List;


public interface BlackBookService {

    long createBlackBook(BlackBook blackBook);

    BlackBook updateBlackBook(BlackBook blackBook);

    void deleteBlackBook(long id);

    List<BlackBook> getAllBlackBooks();

    BlackBook getBlackBook(long id);

}
