package com.mindtree.shoppingCartApplication.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.shoppingCartApplication.dao.CartDao;
import com.mindtree.shoppingCartApplication.exception.CannotDeleteException;
import com.mindtree.shoppingCartApplication.exception.CartNotFoundException;
import com.mindtree.shoppingCartApplication.exception.ProductIdNotFoundException;
import com.mindtree.shoppingCartApplication.exception.ProductNotFoundException;
import com.mindtree.shoppingCartApplication.exception.UserNotFoundException;
import com.mindtree.shoppingCartApplication.model.Cart;
import com.mindtree.shoppingCartApplication.model.Product;
import com.mindtree.shoppingCartApplication.model.User;
import com.mindtree.shoppingCartApplication.repository.CartRepository;
import com.mindtree.shoppingCartApplication.repository.ProductRepository;
import com.mindtree.shoppingCartApplication.repository.UserRepository;
@Component
public class CartDaoImpl implements CartDao  {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	UserRepository userRepository;
	

	@Override

	public Cart addProductsToCart(int userID, int productID) throws UserNotFoundException,ProductIdNotFoundException {
		Cart cart=new Cart();
		if(!userRepository.existsById(userID))
		{
			throw new UserNotFoundException("user not found");
		}
		else if(!productRepository.existsById(productID))
		{
			throw new ProductIdNotFoundException("Product Not Found");
		}
		else
		{
			 cart=userRepository.findById(userID).get().getCart();
			List<Product> productList=new ArrayList<>();
			Product product=productRepository.findById(productID).get();
			product.setProductQuantity(product.getProductQuantity()+1);
			product.setCart(cart);
			productList.add(product);
			
			cart.setProduct(productList);
			cart.setQuantity(cart.getQuantity()+1);
			cart.setTotalCartPrice(cart.getTotalCartPrice()+product.getPrice());
			cartRepository.saveAndFlush(cart);
			
			User user=userRepository.findById(userID).get();
			user.setCart(cart);
			userRepository.saveAndFlush(user);
			
			return cart;
		}
		
	}

	@Override
	
	public Cart deleteSingleProductFromCart(int userId,int productId) throws UserNotFoundException,ProductNotFoundException, CartNotFoundException, ProductIdNotFoundException {
		if(!userRepository.existsById(userId))
		{
			throw new UserNotFoundException("user not found");
		}
		else if(!productRepository.existsById(productId))
		{
			throw new ProductIdNotFoundException("Product Not Found");
		}
		Cart cart=userRepository.findById(userId).get().getCart();
		if(cart==null)
		{
			throw new CartNotFoundException("Cart Not Found");
		}
		Product product=productRepository.findById(productId).get();
		if(product.getCart()==null || product.getCart().getCartId()!=cart.getCartId())
		{
			throw new ProductNotFoundException("Product Not Found");
		}
		cart.setTotalCartPrice(cart.getTotalCartPrice()-(product.getPrice()*product.getProductQuantity()));
		cart.setQuantity(cart.getQuantity()-product.getProductQuantity());
		product.setProductQuantity(0);
		product.setCart(null);
		productRepository.save(product);
		cartRepository.save(cart);
		return cart;
	}

	@Override
	
	public String deleteAllProductsFromCart(int userId) throws UserNotFoundException,CartNotFoundException {
		if(!userRepository.existsById(userId))
		{
			throw new UserNotFoundException("user not found");
		}
		Cart cart=userRepository.findById(userId).get().getCart();
		if(cart==null)
		{
			throw new CartNotFoundException("Cart Not Found");
		}
		List<Product> productList=new ArrayList<>();
		for (Product product : productList) {
			product.setCart(null);
			product.setProductQuantity(0);
			productRepository.save(product);
		}
		cart.setQuantity(0);
		cart.setTotalCartPrice(0);
		cartRepository.save(cart);
		return "Cart is Empty";
	}

	@Override
	
	public Cart updateProductQuantity(int userId, int productId, int productQuantity) throws UserNotFoundException,CartNotFoundException, ProductNotFoundException, ProductIdNotFoundException, CannotDeleteException {
		if(!userRepository.existsById(userId))
		{
			throw new UserNotFoundException("user not found");
		}
		else if(!productRepository.existsById(productId))
		{
			throw new ProductIdNotFoundException("Product Not Found");
		}
		Cart cart=userRepository.findById(userId).get().getCart();
		if(cart==null)
		{
			throw new CartNotFoundException("Cart Not Found");
		}
		Product product=productRepository.findById(productId).get();
		if(product.getCart()==null || product.getCart().getCartId()!=cart.getCartId())
		{
			throw new ProductNotFoundException("Product Not Found");
		}
		if((productQuantity==0)||( (productQuantity <0) && (productQuantity+product.getProductQuantity()==0)))
		{
			product=productRepository.findById(productId).get();
			int productQuantity2=product.getProductQuantity();
			float productPrice=product.getPrice();
			product.setCart(null);
			product.setProductQuantity(0);
			productRepository.save(product);
			cart.setQuantity(cart.getQuantity()-productQuantity2);
			cart.setTotalCartPrice(cart.getTotalCartPrice()-(productQuantity2*productPrice));
			cartRepository.save(cart);
			return cart;
		}
		else if((productQuantity <0) && (productQuantity+product.getProductQuantity()<0))
		{
			throw new CannotDeleteException("Updation upto quantity 1 is allowed");
		}
		product.setProductQuantity(productQuantity+product.getProductQuantity());
		productRepository.save(product);
		float productPrice=product.getPrice();
		cart.setQuantity(cart.getQuantity()+productQuantity);
		cart.setTotalCartPrice(cart.getTotalCartPrice()+(productQuantity*productPrice));
		cartRepository.save(cart);
		return cart;
	}

	@Override
	
	public Cart viewCart(int userID) throws UserNotFoundException,CartNotFoundException {
		if(!userRepository.existsById(userID))
		{
			throw new UserNotFoundException("user not found");
		}
		Cart cart=userRepository.findById(userID).get().getCart();
		if(cart==null)
		{
			throw new CartNotFoundException("Cart Not Found");
		}
		return cart;
	}

}
