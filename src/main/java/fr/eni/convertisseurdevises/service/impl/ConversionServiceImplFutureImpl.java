package fr.eni.convertisseurdevises.service.impl;

import fr.eni.convertisseurdevises.bo.Currency;
import fr.eni.convertisseurdevises.bo.RatesConversion;
import fr.eni.convertisseurdevises.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

/**
 * On peut imagine une future implémentation qui s'interface avec une BD
 */
public class ConversionServiceImplFutureImpl implements CurrencyConversionService {

    @Override
    public Double convert(Double montant, Currency from, Currency to) {
      // TODO
        return null ;
    }
}
