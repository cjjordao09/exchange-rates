package com.fnb.exchangerates.controller;

import com.fnb.exchangerates.domain.CurrencyRate;
import com.fnb.exchangerates.dto.CurrencyRateDTO;
import com.fnb.exchangerates.dto.MozDefaultCurrencyRate;
import com.fnb.exchangerates.exception.RateNotFoundException;
import com.fnb.exchangerates.mapper.MapStructMapper;
import com.fnb.exchangerates.repository.CurrencyRateRepository;
import com.fnb.exchangerates.util.Provider;
import com.fnb.exchangerates.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CurrencyRateController {

    private MapStructMapper mapstructMapper;

    private final CurrencyRateRepository repository;

    @Autowired
    public CurrencyRateController(CurrencyRateRepository repository, MapStructMapper mapstructMapper){
        this.repository = repository;
        this.mapstructMapper = mapstructMapper;
    }

    @GetMapping("/rates")
    public EntityModel<MozDefaultCurrencyRate> all() {

        MozDefaultCurrencyRate mozDefaultCurrencyRate = new MozDefaultCurrencyRate(Result.SUCCESS.value, Provider.FNB.value,
                mapstructMapper.toArrayCurrencyRateDTO(repository.findAll()));


        return EntityModel.of(mozDefaultCurrencyRate,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CurrencyRateController.class).all()).withSelfRel());


    }

    @PostMapping("/rate")
    public EntityModel<MozDefaultCurrencyRate> newRate(@RequestBody CurrencyRateDTO currencyRateDTO){

        CurrencyRate currencyRateResult =  repository.save(mapstructMapper.toCurrencyRate(currencyRateDTO));

        MozDefaultCurrencyRate mzDfltCurrencyRate = new MozDefaultCurrencyRate(Result.SUCCESS.value, Provider.FNB.value,
                mapstructMapper.toCurrencyRateDTO(currencyRateResult));

        return EntityModel.of(mzDfltCurrencyRate,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CurrencyRateController.class).one(currencyRateResult
                        .getId())).withRel("CurrencyRate"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CurrencyRateController.class).all())
                        .withRel("MozDefaultCurrencyRate"));

    }



    @GetMapping("/rate/{id}")
    public EntityModel<MozDefaultCurrencyRate> one(@PathVariable Long id){

        MozDefaultCurrencyRate mzDfltCurrencyRate = new MozDefaultCurrencyRate(Result.SUCCESS.value, Provider.FNB.value,
                mapstructMapper.toCurrencyRateDTO(repository.findById(id).orElseThrow(
                        () -> new RateNotFoundException(id))));

        return EntityModel.of(mzDfltCurrencyRate,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CurrencyRateController.class).one(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CurrencyRateController.class).all())
                        .withRel("MozDefaultCurrencyRate"));
    }

    @PutMapping("/rate/{id}")
    public CurrencyRate replaceRate(@RequestBody CurrencyRate newCurrencyRate, @PathVariable Long id){
        return repository.findById(id).map(currencyRate -> {
            currencyRate.setCurrency(newCurrencyRate.getCurrency());
            currencyRate.setPurchase(newCurrencyRate.getPurchase());
            currencyRate.setSale(newCurrencyRate.getSale());
            return repository.save(currencyRate);
        }).orElseGet(() -> {
           newCurrencyRate.setId(id);
           return repository.save(newCurrencyRate);
        });
    }


    @DeleteMapping("/rate/{id}")
    public void deleteRate(@PathVariable Long id){
        repository.deleteById(id);
    }
}
