package com.serveTechIT.ServeTechIt.storeProduct.controllers;

import com.serveTechIT.ServeTechIt.storeProduct.Categories;

public record AddProductRequest(
        String name,
        String price,
        String category
) {
}
