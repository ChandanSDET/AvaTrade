package com.bhas.complex.payload;

import io.restassured.response.Response;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
public class RndWithJsonObject {


  public static void main(String[] args) {
    Response response = given().get("https://catfact.ninja/fact");
    response.prettyPrint();
    LinkedHashMap<Object, Object> o = response.jsonPath().getJsonObject("");
    System.out.println(o);
    // JSONObject obj = new JSONObject(response);
    o.remove("length");
    Map<String, Object> demo = new LinkedHashMap<>();
    demo.put("Village", "Bpd");
    demo.put("Wd No", 3);
    o.put("hirarchy", Arrays.asList(3, 4));
    o.put("address", demo);
    System.out.println(o);
    List<Integer> e = (List<Integer>) o.get("hirarchy");
    System.out.println(e.get(0));
  }
}
