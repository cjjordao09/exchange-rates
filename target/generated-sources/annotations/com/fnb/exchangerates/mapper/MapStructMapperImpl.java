package com.fnb.exchangerates.mapper;

import com.fnb.exchangerates.domain.CurrencyRate;
import com.fnb.exchangerates.dto.CurrencyRateDTO;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-20T15:18:32+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public CurrencyRateDTO toCurrencyRateDTO(CurrencyRate currencyRate) {
        if ( currencyRate == null ) {
            return null;
        }

        Long id = null;
        String currency = null;
        double purchase = 0.0d;
        double sale = 0.0d;

        id = currencyRate.getId();
        currency = currencyRate.getCurrency();
        purchase = currencyRate.getPurchase();
        sale = currencyRate.getSale();

        CurrencyRateDTO currencyRateDTO = new CurrencyRateDTO( id, currency, purchase, sale );

        return currencyRateDTO;
    }

    @Override
    public CurrencyRate toCurrencyRate(CurrencyRateDTO currencyRateDTO) {
        if ( currencyRateDTO == null ) {
            return null;
        }

        CurrencyRate currencyRate = new CurrencyRate();

        currencyRate.setId( currencyRateDTO.getId() );
        currencyRate.setCurrency( currencyRateDTO.getCurrency() );
        currencyRate.setPurchase( currencyRateDTO.getPurchase() );
        currencyRate.setSale( currencyRateDTO.getSale() );

        return currencyRate;
    }

    @Override
    public CurrencyRateDTO[] toArrayCurrencyRateDTO(List<CurrencyRate> currencyRate) {
        if ( currencyRate == null ) {
            return null;
        }

        CurrencyRateDTO[] currencyRateDTOTmp = new CurrencyRateDTO[currencyRate.size()];
        int i = 0;
        for ( CurrencyRate currencyRate1 : currencyRate ) {
            currencyRateDTOTmp[i] = toCurrencyRateDTO( currencyRate1 );
            i++;
        }

        return currencyRateDTOTmp;
    }

    @Override
    public CurrencyRate[] toArrayCurrencyRate(CurrencyRateDTO[] currencyRateDTO) {
        if ( currencyRateDTO == null ) {
            return null;
        }

        CurrencyRate[] currencyRateTmp = new CurrencyRate[currencyRateDTO.length];
        int i = 0;
        for ( CurrencyRateDTO currencyRateDTO1 : currencyRateDTO ) {
            currencyRateTmp[i] = toCurrencyRate( currencyRateDTO1 );
            i++;
        }

        return currencyRateTmp;
    }
}
