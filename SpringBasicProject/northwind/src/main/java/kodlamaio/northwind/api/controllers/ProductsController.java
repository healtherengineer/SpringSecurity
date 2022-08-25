package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Tüm ortamlarda sen çalışacaksın demek
@RestController
@RequestMapping("/api/products") //filter gibi düşün böyle bir url geldiğinde bu class karşılayacak
public class ProductsController {

    //gelen istekleri karşılayıp business 'a iletir
    //eğer istekler business ta ki iş kurallarından geçerse dataAccess e yollanır
    //Böylece veriyi yönetmiş oluruz .
    //http://localhost:8080/swagger-ui.html#/
    private ProductService productService;

    //Product service olan SOMUT bir sınıf bulup otomatik new ler spring tarafında yönetilir .
    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll") // www.abc.com/api/products/getAll
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();

    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {

        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {

        return this.productService.getByProductName(productName);

    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName
            , @RequestParam("categoryId") int categoryId) {

        return this.productService.getByProductNameAndCategoryId(productName, categoryId);

    }


    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return this.productService.getByProductNameContains(productName);

    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

        return this.productService.getAll(pageNo, pageSize);
    }
    //implemente edilmemiş serviclere controller yazacağım

    @GetMapping("/getAllSorted")
    public DataResult<List<Product>> getAllSorted() {
        return this.productService.getAllSorted();
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam("productName") String productName,
                                                                  @RequestParam("categoryId") int categoryId) {
        return this.productService.getByProductNameOrCategoryId(productName, categoryId);

    }

    @GetMapping("/getByCategoryIdIn")
    public DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories) {

        return this.productService.getByCategoryIdIn(categories);
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return this.productService.getProductWithCategoryDetails();


    }


}
