package com.mindtree.shoppingCartApplication.dao;

import java.util.List;

import com.mindtree.shoppingCartApplication.controllerExceptionHandler.BookNotFoundException;
import com.mindtree.shoppingCartApplication.exception.AppralNotFoundException;
import com.mindtree.shoppingCartApplication.exception.ProductIdNotFoundException;
import com.mindtree.shoppingCartApplication.exception.ProductNameNotFoundException;
import com.mindtree.shoppingCartApplication.model.Apparal;
import com.mindtree.shoppingCartApplication.model.Book;
import com.mindtree.shoppingCartApplication.model.Product;

public interface ProductDao {
	 Product searchByProductId(int productId) throws ProductIdNotFoundException;
	 Product searchByProductName(String productName) throws ProductNameNotFoundException;
	 List<Apparal> searchByApparal() throws AppralNotFoundException;
	 List<Book> searchByBook() throws BookNotFoundException;

}
