package fr.eni.convertisseurdevises.service;

import fr.eni.convertisseurdevises.bo.Currency;

/**
 * Je défini la fonctionnalité que je cherche à rendre disponible à mon Controller
 * ici : une méthode qui retourne un montant convertit d'une devise (from) en une autre (to)
 */
public interface CurrencyConversionService {
    Double convert(Double montant, Currency from, Currency to);
}
