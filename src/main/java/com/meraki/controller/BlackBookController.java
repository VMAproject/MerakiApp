package com.meraki.controller;

import com.meraki.entity.BlackBook;
import com.meraki.service.interfaces.BlackBookService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlackBookController {

    private static final Logger logger = Logger.getLogger(BlackBookController.class);

    private BlackBookService blackBookService;

    @Autowired
    @Qualifier("blackBookServiceImpl")
    public void setBlackBookService(BlackBookService blackBookService) {
        this.blackBookService = blackBookService;
    }

    @RequestMapping("getAllBlackBookLists")
    public ModelAndView getAllBlackBook() {
        List<BlackBook> blackBookList = blackBookService.getAllBlackBooks();
        logger.info("*** Black Book Controller *** get all black book" + blackBookList);
        return new ModelAndView("blackBook/blackBookList", "blackBookList", blackBookList);

    }

    @RequestMapping("createBlackBook")
    public ModelAndView createBlackBook(@ModelAttribute BlackBook blackBook) {
        logger.info("*** Black Book Controller *** create black book " + blackBook);
        return new ModelAndView("blackBook/blackBookForm");
    }

    @RequestMapping("editBlackBook")
    public ModelAndView editBlackBook(@RequestParam long id, @ModelAttribute BlackBook blackBook) {
        blackBook = blackBookService.getBlackBook(id);
        logger.info("*** Black Book Controller *** edit black book " + blackBook);
        return new ModelAndView("blackBook/blackBookForm", "blackBookObject", blackBook);
    }

    @RequestMapping("saveBlackBook")
    public ModelAndView saveBlackBook(@ModelAttribute BlackBook blackBook) {
        logger.info("*** Black Book Controller *** pre save black book" + blackBook);
        if (blackBook.getId() == 0) {
            blackBookService.createBlackBook(blackBook);
            logger.info("*** Black Book Controller *** create black book " + blackBook);
        } else {
            blackBookService.updateBlackBook(blackBook);
            logger.info("*** Black Book Controller *** save black book " + blackBook);
        }


        return new ModelAndView("redirect:getAllBlackBookLists");
    }

    @RequestMapping("deleteBlackBook")
    public ModelAndView deleteBlackBook(@RequestParam long id) {
        blackBookService.deleteBlackBook(id);
        logger.info("*** Black Book Controller *** delete black book " + id);
        return new ModelAndView("redirect:getAllBlackBookLists");
    }


}
