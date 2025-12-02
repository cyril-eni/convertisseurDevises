package fr.eni.convertisseurdevises.controller;

import fr.eni.convertisseurdevises.bo.Currency;
import fr.eni.convertisseurdevises.bo.RatesConversion;
import fr.eni.convertisseurdevises.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClient;

import java.text.DecimalFormat;

@Controller
@RequestMapping("/converter")
public class ConvertController {

    @Autowired
    private CurrencyConversionService conversionService;

    @GetMapping
    public String getConverter(){
        // en GET, je retourne simplement le template
        return "currencyconverter";
    }

    /**
     * Cette méthode va appeler une API, et afficher son résultat dans la vue : responseAPI
     */
    @PostMapping
    public String convert(Double montant, Currency from, Currency to, Model model){

        // je délègue la conversion de devis à mon service
        Double conversion = conversionService.convert(montant,from,to);
        System.out.println("montantConverti = " + conversion);

        model.addAttribute("montantConverti", conversion);
        model.addAttribute("montant", montant);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        // je redirige sur le template pour afficher le resultat
        return "currencyconverter";
    }
}
