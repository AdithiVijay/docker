package com.eatza.order.service.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.eatza.order.dto.DeliveryDto;

@FeignClient(name="DeliveryService")
public interface OrderFeign {
	@PostMapping("/delivery")
	DeliveryDto deliverDetails(DeliveryDto delivery);

}
