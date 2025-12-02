package fr.eni.convertisseurdevises.service.impl;

import fr.eni.convertisseurdevises.bo.Currency;
import fr.eni.convertisseurdevises.bo.RatesConversion;
import fr.eni.convertisseurdevises.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ConversionServiceImpl implements CurrencyConversionService {

    @Value("${currencyapi.app-id}")
    private String appId;

    @Value("${currencyapi.base-url}")
    private String baseUrl;

    public RatesConversion getRateConversion() {
        System.out.println("baseUrl : " + baseUrl);
        RestClient restClient = RestClient.create(baseUrl);
        RatesConversion ratesConversion =
                // j'effectue requête GET sur https://api.restful-api.dev/objects/7
                restClient.get().uri("/latest.json?app_id=" + appId)
                // je transforme le resultat JSON en objet qui correspond à la structure de ma classe RatesConversion
                // => je vais remplir l'attribut de type Map rates avec les valeurs du JSON de retour
                .retrieve().body(RatesConversion.class);
        return ratesConversion;
    }

    @Override
    public Double convert(Double montant, Currency from, Currency to) {
        // 1 - je récupère la classe de conversion (qui stocke les valuers dans une Map)
        RatesConversion ratesConversion = getRateConversion();
        // on va recupérer le taux de conversion de la devise entrante depuis notre Map des rates
        Double rateFrom = ratesConversion.getRates().get(from.toString());
        // on va recupérer le taux de conversion de la devise sortante
        Double rateTo = ratesConversion.getRates().get(to.toString());
        // on effectue le calcul pour avoir la valeur finale : montant / tauxDeConversionEntrant  * tauxDeConversionSortant
        return montant / rateFrom * rateTo;
    }
}
