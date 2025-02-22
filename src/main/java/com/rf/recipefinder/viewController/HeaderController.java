package com.rf.recipefinder.viewController;

import com.rf.recipefinder.datamodel.category.CategoryService;
import com.rf.recipefinder.datamodel.tag.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/header")
public class HeaderController {

    private final TagService tagService;
    private final CategoryService categoryService;

    public HeaderController(TagService tagService, CategoryService categoryService) {
        this.tagService = tagService;
        this.categoryService = categoryService;
    }


    @GetMapping("/menu")
    public String showMenu(Model model) {
        model.addAttribute("tags", tagService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "fragments/menu";
    }

}
