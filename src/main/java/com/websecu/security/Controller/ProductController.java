package com.websecu.security.Controller;

;
import com.websecu.security.Dto.ProductDto;
import com.websecu.security.Service.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/products")
    public List<ProductDto> findAll(){
        return productService.findAll();

    }
    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable int id){

        return productService.findById(id);
    }
    @PostMapping("/product")
    public ProductDto create(@RequestBody ProductDto p){
        return productService.add(p);

    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        return productService.deleteById(id);

    }
    @PutMapping("/{id}")
    public ProductDto update(@PathVariable int id,@RequestBody ProductDto p){

        return productService.update(id,p);
    }
    @GetMapping("/filter-price-greater-than")
    public List<ProductDto> findAllByPriceGreaterThan(@RequestParam("min-price") Long price){
        return productService.findAllByPriceGreaterThan(price);

    }
    @GetMapping("/filter-catagory-and-price-less-than")
    public List<ProductDto> findByCategoryAndPriceLessThan(@RequestParam("catagoryName") String catagoryName,@RequestParam("max-price") Double price){
        return productService.findByCatagoryAndPriceLessThan(catagoryName,price);
    }
    @GetMapping("/filter-name")
    public List<ProductDto> findAllByNameContains(@RequestParam("name") String keyword){
        return productService.findAllByNameContains(keyword);
    }
}
