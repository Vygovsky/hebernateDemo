package entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product extends Model {
    private String title;
    private BigDecimal priceList;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
    private ProductCategory productCategory;

    public Product() {
    }

    public Product(Long id) {
        super(id);
    }

    public Product(Long id, String title, BigDecimal priceList, String description, ProductCategory productCategory) {
        super(id);
        this.title = title;
        this.priceList = priceList;
        this.description = description;
        this.productCategory = productCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return priceList;
    }

    public void setPrice(BigDecimal price) {
        this.priceList = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", priceList=" + priceList +
                ", description='" + description + '\'' + productCategory.getTitle()+
                '}';
    }
}

