package java_web.controller;


import jakarta.validation.Valid;
import java_web.dto.CategoryDTO;
import java_web.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping()
    public String list(@RequestParam(value = "name", required = false) String name , Model model) {
        if (name != null && name.isEmpty()) {
            model.addAttribute("categories", categoryService.getAllCategories(name));
        }else {
            model.addAttribute("categories", categoryService.getAllCategories(null));
        }
        return "list-category";
    }

    @GetMapping("/add")
    public String getAddCategoryPage(@ModelAttribute("categoryDto") CategoryDTO categoryDTO, Model model) {
        model.addAttribute("categoryDto", categoryDTO);
        return "form-category";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("categoryDto") CategoryDTO categoryDTO, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "list-category";
        }

        if (categoryService.isExisted(categoryDTO.getName())) {
            model.addAttribute("error", "Tên danh muc đã tồn tại!");
            return "form-category";
        } else if (categoryService.addCategory(categoryDTO.getName(),categoryDTO.getDescription(), categoryDTO.getStatus())) {
            model.addAttribute("error", "Them danh muc that bai!");
            return "form-category";
        }else {
            return "redirect:/category";
        }
    }
}
