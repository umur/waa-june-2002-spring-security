package com.miu.project6.service.impl;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    @Override
    public void save(Product p) {
        productRepo.save(p);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(int id) {
        return productRepo.findById(id).get();
    }


    @Override
    public List<ProductDtoResponse> getAll() {
//    var result = new ArrayList<Product>();
//    productRepo.findAll().forEach(result::add);
        var products = productRepo.findAll();
        Type listType = new TypeToken<List<ProductDtoResponse>>(){}.getType();
        return modelMapper.map(products,listType);
    }
}
