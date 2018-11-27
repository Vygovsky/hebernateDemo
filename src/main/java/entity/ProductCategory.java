package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_category")
public class ProductCategory extends Model {
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_product_category", referencedColumnName = "id")
    private ProductCategory parentProductCategory;

    @OneToMany(mappedBy = "productCategory")
    private Set<Product> products = new HashSet<Product>();

    public ProductCategory() {
    }

    public ProductCategory(Long id) {
        super(id);
    }

    public ProductCategory(String title) {
        this.title = title;
    }

    public ProductCategory(Long id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductCategory getParentProductCategory() {
        return parentProductCategory;
    }

    public void setParentProductCategory(ProductCategory parentProductCategory) {
        this.parentProductCategory = parentProductCategory;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "title='" + title + '\'' +
                '}';
    }
}
