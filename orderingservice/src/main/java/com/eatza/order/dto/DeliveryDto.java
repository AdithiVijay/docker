package com.eatza.order.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryDto {
	
	private Long orderId;
	private String status;
	private Long customerId;
	private Long restaurantId;
	
	

	public DeliveryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryDto(Long orderId, String status, Long customerId, Long restaurantId) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	

	


	

}
