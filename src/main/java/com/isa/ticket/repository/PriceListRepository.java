package com.isa.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ticket.domain.PriceList;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList, Long> {

}
