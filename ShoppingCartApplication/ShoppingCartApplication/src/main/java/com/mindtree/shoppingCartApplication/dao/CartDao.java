package com.mindtree.shoppingCartApplication.dao;

import com.mindtree.shoppingCartApplication.exception.CannotDeleteException;
import com.mindtree.shoppingCartApplication.exception.CartNotFoundException;
import com.mindtree.shoppingCartApplication.exception.ProductIdNotFoundException;
import com.mindtree.shoppingCartApplication.exception.ProductNotFoundException;
import com.mindtree.shoppingCartApplication.exception.UserNotFoundException;
import com.mindtree.shoppingCartApplication.model.Cart;

public interface CartDao {
	Cart addProductsToCart(int userID,int productID) throws UserNotFoundException, ProductIdNotFoundException;
	Cart deleteSingleProductFromCart(int userId,int productId) throws UserNotFoundException, ProductNotFoundException, CartNotFoundException, ProductIdNotFoundException;
	String deleteAllProductsFromCart(int userId) throws UserNotFoundException, CartNotFoundException;
	Cart updateProductQuantity(int userId,int productId,int productQuantity) throws UserNotFoundException, ProductIdNotFoundException, CartNotFoundException, ProductNotFoundException, CannotDeleteException;
	Cart viewCart(int userID) throws UserNotFoundException, CartNotFoundException;

}
