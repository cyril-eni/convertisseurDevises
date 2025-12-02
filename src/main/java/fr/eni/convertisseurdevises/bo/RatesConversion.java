package fr.eni.convertisseurdevises.bo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Cette classe va être mappée avec le retour de l'appel à l'API qui est de type :
 *
 * {
 *   "disclaimer": "Usage subject to terms: https://openexchangerates.org/terms",
 *   "license": "https://openexchangerates.org/license",
 *   "timestamp": 1764673200,
 *   "base": "USD",
 *   "rates": {
 *     "AED": 3.6725,
 *     "AFN": 66.387289,
 *     "ALL": 83.186528,
 *     "AMD": 381.596998
 *    }
 *
 *    Note : seul la propriété rates va être mappée
 */
@Data
public class RatesConversion {
    private Map<String, Double> rates =  new HashMap<>();
}
