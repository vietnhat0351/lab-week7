package com.example.labweek7.controllers;

import com.example.labweek7.models.Product;
import com.example.labweek7.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductServices services;

    @GetMapping
    public String getAllProduct(
            @RequestParam(value = "page", defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int pageSize,
//            @RequestParam(defaultValue = "name") String sortBy,
//            @RequestParam(defaultValue = "asc") String sortDirection
            Model model
    ) {
        Sort.Direction direction = Sort.Direction.ASC;
        // Pageable pageable = PageRequest.of(0, 50, Sort.by(direction, "name"));
        Page<Product> productPage = services.findPaginated(page ,50,"name",Sort.Direction.ASC.name());

        model.addAttribute("pageNumber", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("pagedProducts", productPage.getContent());

        return "product-list";
    }
}
