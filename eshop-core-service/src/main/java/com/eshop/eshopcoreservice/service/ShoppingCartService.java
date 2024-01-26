package com.eshop.eshopcoreservice.service;

import com.eshop.eshopcoreservice.dto.ProductDto;
import com.eshop.eshopcoreservice.entity.ShoppingCartEntity;
import com.eshop.eshopcoreservice.entity.ShoppingCartItemEntity;

public interface ShoppingCartService {
    ShoppingCartEntity saveOrUpdate(ShoppingCartItemEntity item);

    ShoppingCartEntity getShoppingCart(Long customerId);

    ShoppingCartItemEntity populateShoppingCartItem(ShoppingCartItemEntity item,ShoppingCartEntity shoppingCart);

    void removeShoppingCart(Long id);
}
