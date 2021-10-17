package com.mindtree.shoppingCartApplication.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.shoppingCartApplication.controllerExceptionHandler.BookNotFoundException;
import com.mindtree.shoppingCartApplication.dao.ProductDao;
import com.mindtree.shoppingCartApplication.exception.AppralNotFoundException;
import com.mindtree.shoppingCartApplication.exception.ProductIdNotFoundException;
import com.mindtree.shoppingCartApplication.exception.ProductNameNotFoundException;
import com.mindtree.shoppingCartApplication.model.Apparal;
import com.mindtree.shoppingCartApplication.model.Book;
import com.mindtree.shoppingCartApplication.model.Product;
import com.mindtree.shoppingCartApplication.repository.ApparalRepository;
import com.mindtree.shoppingCartApplication.repository.BookRepository;
import com.mindtree.shoppingCartApplication.repository.ProductRepository;
@Component
public class ProductDaoImpl implements ProductDao {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	ApparalRepository apparalRepository;

	@Override
	
	public Product searchByProductId(int productId) throws ProductIdNotFoundException {
		Product product=productRepository.findById(productId).
				orElseThrow(()->new ProductIdNotFoundException("No product Found with this ID"));
		return product;
	}

	@Override
	public Product searchByProductName(String productName) throws ProductNameNotFoundException {
		Product product=new Product();
		if(productRepository.existsByProductName(productName)==true)
		{
		 product= productRepository.findByProductName(productName);
		}
		else
		{
			throw new ProductNameNotFoundException("Product Name Not found");
		}
		return product;
	}

	@Override
	public List<Apparal> searchByApparal() throws AppralNotFoundException {
		List<Apparal> apparal=new ArrayList<>();
		if(apparalRepository.findAll().isEmpty())
		{
			throw new AppralNotFoundException("Apparal not found");
		}
		else
		{
			 apparal=apparalRepository.findAll();
		}
		return apparal;
	}

	@Override
	public List<Book> searchByBook() throws BookNotFoundException {
		
		if(bookRepository.findAll().isEmpty())
		{
			throw new BookNotFoundException("Book not found");
		}
		
		return bookRepository.findAll();
	}
	
	

}
