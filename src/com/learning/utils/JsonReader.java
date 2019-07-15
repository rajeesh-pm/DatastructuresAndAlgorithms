//package com.learning.utils;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import javax.json.Json;
//import javax.json.JsonArray;
//import javax.json.JsonObject;
//import javax.json.JsonReader;
//import javax.json.JsonValue;
//
//
//public class JsonReader {
//
//
//    public static void main(String[] args) throws IOException {
//
//        URL url = new URL("http://localhost:8080/RESTfulExample/json/product/get");
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Accept", "application/json");
//
//        if (conn.getResponseCode() != 200) {
//            throw new RuntimeException("Failed : HTTP error code : "
//                    + conn.getResponseCode());
//        }
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(
//                (conn.getInputStream())));
//
//        String output;
//        System.out.println("Output from Server .... \n");
//        while ((output = br.readLine()) != null) {
//            System.out.println(output);
//        }
//
//        JsonObject jsonObject = jsonReader.readObject();
//
//        //we can close IO resource and JsonReader now
//        jsonReader.close();
//        fis.close();
//
//        //Retrieve data from JsonObject and create Employee bean
//        Employee emp = new Employee();
//
//        emp.setId(jsonObject.getInt("id"));
//        emp.setName(jsonObject.getString("name"));
//        emp.setPermanent(jsonObject.getBoolean("permanent"));
//        emp.setRole(jsonObject.getString("role"));
//
//        //reading arrays from json
//        JsonArray jsonArray = jsonObject.getJsonArray("phoneNumbers");
//        long[] numbers = new long[jsonArray.size()];
//        int index = 0;
//        for (JsonValue value : jsonArray) {
//            numbers[index++] = Long.parseLong(value.toString());
//        }
//        emp.setPhoneNumbers(numbers);
//
//        //reading inner object from json object
//        JsonObject innerJsonObject = jsonObject.getJsonObject("address");
//        Address address = new Address();
//        address.setStreet(innerJsonObject.getString("street"));
//        address.setCity(innerJsonObject.getString("city"));
//        address.setZipcode(innerJsonObject.getInt("zipcode"));
//        emp.setAddress(address);
//
//        //print employee bean information
//        System.out.println(emp);
//
//    }
//
//}