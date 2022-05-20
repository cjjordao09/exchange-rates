package com.fnb.exchangerates.repository;

import com.fnb.exchangerates.domain.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {

}
