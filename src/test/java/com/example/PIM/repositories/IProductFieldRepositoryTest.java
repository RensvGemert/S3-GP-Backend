package com.example.PIM.repositories;

import com.example.PIM.model.Field;
import com.example.PIM.model.Product;
import com.example.PIM.model.ProductField;
import com.example.PIM.model.ProductFieldKey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@DataJpaTest
class IProductFieldRepositoryTest {

    @Autowired
    private IProductFieldRepository underTestProductField;
    @Autowired
    private IProductRepository underTestProduct;
    @Autowired
    private IFieldRepository underTestField;

    @Test
    void checkIfAllProductFielsFromProductAreSelected() {
        Field field1 = new Field("testfield1");
        underTestField.save(field1);

        Product product1 = new Product("testtitle1", "testdiscription1", new BigDecimal(1), 1, "testimage1", LocalDateTime.now(), LocalDateTime.now(), null);
        underTestProduct.save((product1));

        Optional<Product> productCreated1 = underTestProduct.findById(1);
        Optional<Field> fieldCreated1 = underTestField.findById(1);
        Product pc1 = productCreated1.get();
        Field fc1 = fieldCreated1.get();


        ProductFieldKey key = new ProductFieldKey(pc1.getId(), fc1.getId());
        ProductField pf1 = new ProductField(key, fc1, pc1, "testvalue1");


        //underTestProductField.save(pf1);

        //List<ProductField> productFields = underTestProductField.selectAllProductFieldsFromProduct(pc1.getId());

        //assertThat(productFields.stream().count()).isEqualTo(0);

    }

    @Test
    void deleteProductFieldFromProduct() {

    }
}