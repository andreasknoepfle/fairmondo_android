package de.handler.mobile.android.shopprototype.interfaces;

import java.util.ArrayList;

import de.handler.mobile.android.shopprototype.database.Product;


/**
 * Listener for featured Products
 */
public interface OnFeaturedProductsListener {
    public void onFeaturesProductsResponse(ArrayList<Product> products);
}
