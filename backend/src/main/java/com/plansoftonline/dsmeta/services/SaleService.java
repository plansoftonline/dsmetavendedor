package com.plansoftonline.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.plansoftonline.dsmeta.entities.Sale;
import com.plansoftonline.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	public Page<Sale> findSales(Pageable page) {
		return saleRepository.findAll(page);
	}

	public Page<Sale> findSales(String minDate, String maxDate, Pageable page) {
		
		LocalDate hoje = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()); //criar uma data com dia de hj
		
		LocalDate min = minDate.equals("") ? hoje.minusDays(365) : LocalDate.parse(minDate); //Se a data for vazia pega a data atual - 365 dias
		LocalDate max = maxDate.equals("") ? hoje : LocalDate.parse(maxDate); //Se a data for vazia pega a data atual (hoje)
		
		return saleRepository.findSales(min, max, page);
	}

}
