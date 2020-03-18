package com.doas.jaggaer.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @JsonProperty("ProductItem")
    private List<ProductItem> productItem;

    public List<ProductItem> getProductItem() {
        return productItem;
    }

    public void setProductItem(List<ProductItem> productItem) {
        this.productItem = productItem;
    }
    
    
    
}
