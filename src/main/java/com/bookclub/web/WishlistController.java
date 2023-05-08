package com.bookclub.web;


import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    private WishlistDao wishlistDao;

    public WishlistController()
    {
        wishlistDao = new MongoWishlistDao();
    }




    @RequestMapping(method = RequestMethod.GET, path="/")
    public String showWishlist()
    {

        return "wishlist/list";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/new")
    public String wishlistForm(Model model)
    {
        WishlistItem wishlistItem = new WishlistItem();
        model.addAttribute("wishlistItem",wishlistItem);
        return "wishlist/new";
    }

    public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult)
    {
        System.out.println(wishlistItem.toString());

        System.out.println(bindingResult.getAllErrors());

        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }

        wishlistDao.add(wishlistItem);

        return "redirect:/wishlist";
    }

    private void setWishlistDao(WishlistDao wishlistDao)
    {
        this.wishlistDao = wishlistDao;
    }
}
