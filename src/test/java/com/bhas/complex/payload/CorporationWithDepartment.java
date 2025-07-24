package com.bhas.complex.payload;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CorporationWithDepartment {

  public static String getCorporationWithDepartment(String countryCode) throws Exception {
    switch(countryCode){
      case "ARG":
        return "Mercadolibre INC:Ecommerce:@mercadolibre.com";
      case "BRA":
        return "Petrobras:Oil & Gas:@petrobras.in";
      case "CAN":
        return "Brookfield Asset Management:Finanace:@brookfield.in";
      case "FRA":
        return "AXA:Insurance:@axa.in";
      case "DEU":
        return "Volkswagen Group:Automotive:@volkswagen.com";
      case"GBR":
        List<String> ukCorWithDep = Arrays.asList("BP:Oil & Gas:@bp.com", "HSBC:Banking:@hsbc.com", "HSBC:Finance Service:@hsbcfinance.com", "HSBC:Invesment Service:@hsbcinvestment.com", "Tesco:Retail:@tescofood.in", "Tesco:Retail:@tescoelectric.in");
        return ukCorWithDep.get(new Random().nextInt(ukCorWithDep.size()));
      case"USA":
        List<String> usaCorWithDep = Arrays.asList("Apple:Electronics:@apple.com", "Walmart:retail@walmart.in", "Secondary Markets:Trading:@secondarymarkets.com");
        return usaCorWithDep.get(new Random().nextInt(usaCorWithDep.size()));
      case"AUS":
        return "BHP:Mining:@bhp.in";
      default:
        throw new Exception("Check your country code");
    }
  }
}
