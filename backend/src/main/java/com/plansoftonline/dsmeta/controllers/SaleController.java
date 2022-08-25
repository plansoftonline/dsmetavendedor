package com.plansoftonline.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plansoftonline.dsmeta.entities.Sale;
import com.plansoftonline.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;

	@GetMapping
	public Page<Sale> findSales(Pageable page) {
		return service.findSales(page);
	}

	@GetMapping("/data")
	public Page<Sale> findSalesPeriodo(@RequestParam(value="minDate", defaultValue = "") String minDate, 
			                           @RequestParam(value="maxDate", defaultValue = "") String maxDate, 
			                           Pageable page) {
		return service.findSales(minDate, maxDate, page);
	}

}
