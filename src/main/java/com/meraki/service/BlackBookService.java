package com.meraki.service;

import com.meraki.entity.BlackBook;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BlackBookService {

    long createBlackBook(BlackBook blackBook);

    BlackBook updateBlackBook(BlackBook blackBook);

    void deleteBlackBook(long id);

    List<BlackBook> getAllBlackBooks();

    BlackBook getBlackBook(long id);

}
