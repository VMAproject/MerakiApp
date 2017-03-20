package com.meraki.controller;

import com.meraki.entity.BlackBook;
import com.meraki.service.BlackBookService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Verlamov on 20.03.17.
 */
@Controller
public class BlackBookController {

    private static final Logger logger = Logger.getLogger(BlackBookController.class);


    @Autowired
    private BlackBookService blackBookService;


    @RequestMapping("getAllBlackBookLists")
    public ModelAndView getAllBlackBook() {
        List<BlackBook> blackBookList = blackBookService.getAllBlackBooks();
        logger.info("get all blakc book" + blackBookList);
        return new ModelAndView("blackBookList", "blackBookList", blackBookList);

    }


    @RequestMapping("createBlackBook")
    public ModelAndView createBlackBook(@ModelAttribute BlackBook blackBook) {
        logger.info("create black book " + blackBook);
        return new ModelAndView("blackBookForm");
    }

    @RequestMapping("editBlackBook")
    public ModelAndView editBlackBook(@RequestParam long id, @ModelAttribute BlackBook blackBook) {
        blackBook = blackBookService.getBlackBook(id);
        logger.info("edit black book " + blackBook);
        return new ModelAndView("blackBookForm", "blackBookObject", blackBook);
    }

    @RequestMapping("saveBlackBook")
    public ModelAndView saveBlackBook(@ModelAttribute BlackBook blackBook) {
        logger.info("save black book" + blackBook);
        if (blackBook.getId() == 0) {
            blackBookService.createBlackBook(blackBook);
        } else {
            blackBookService.updateBlackBook(blackBook);
        }
        logger.info("save black book " + blackBook);

        return new ModelAndView("redirect:getAllBlackBookLists");
    }

    @RequestMapping("deleteBlackBook")
    public ModelAndView deleteBlackBook(@RequestParam long id) {
        blackBookService.deleteBlackBook(id);
        logger.info("delete blak book " + id);
        return new ModelAndView("redirect:getAllBlackBookLists");
    }


}
