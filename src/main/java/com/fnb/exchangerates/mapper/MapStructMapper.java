package com.fnb.exchangerates.mapper;

import com.fnb.exchangerates.domain.CurrencyRate;
import com.fnb.exchangerates.dto.CurrencyRateDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    CurrencyRateDTO toCurrencyRateDTO(CurrencyRate currencyRate);

    CurrencyRate toCurrencyRate(CurrencyRateDTO currencyRateDTO);

    CurrencyRateDTO[] toArrayCurrencyRateDTO(List<CurrencyRate> currencyRate);

    CurrencyRate[] toArrayCurrencyRate(CurrencyRateDTO[] currencyRateDTO);


}
