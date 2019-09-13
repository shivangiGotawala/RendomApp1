package com.rendomapp.rendomapp;

import android.util.Log;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by Dell on 21/05/2019.
 */

public class Model {
    String name;
    private boolean isSelected = false;
    ArrayList<String> arrayList = new ArrayList<>() ;

    public Model(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelectedName(String name) {
        arrayList.add(name);
    }

    public void removeUnSelectedName(String name) {
        arrayList.remove(name);
    }


    public void setArrayList(ArrayList<String> arrayList){
        this.arrayList = arrayList;
    }
    public ArrayList<String> getArrayList() {
        Log.e("array size",""+arrayList.size());
        return arrayList;
    }
}





//    public ArrayList<Restaurant> processResults(Response response) {
//        ArrayList<Restaurant> restaurants = new ArrayList<>();
//
//        try {
//            String jsonData = response.body().string();
//            JSONObject yelpJSON = new JSONObject(jsonData);
//            JSONArray businessesJSON = yelpJSON.getJSONArray("businesses");
//            for (int i = 0; i < businessesJSON.length(); i++) {
//                JSONObject restaurantJSON = businessesJSON.getJSONObject(i);
//                String name = restaurantJSON.getString("name");
//                String phone = restaurantJSON.optString("display_phone", "Phone not available");
//                String website = restaurantJSON.getString("url");
//                double rating = restaurantJSON.getDouble("rating");
//
//                String imageUrl = restaurantJSON.getString("image_url");
//
//                double latitude = (double) restaurantJSON.getJSONObject("coordinates").getDouble("latitude");
//
//                double longitude = (double) restaurantJSON.getJSONObject("coordinates").getDouble("longitude");
//
//                ArrayList<String> address = new ArrayList<>();
//                JSONArray addressJSON = restaurantJSON.getJSONObject("location")
//                        .getJSONArray("display_address");
//                for (int y = 0; y < addressJSON.length(); y++) {
//                    address.add(addressJSON.get(y).toString());
//                }
//
//                ArrayList<String> categories = new ArrayList<>();
//                JSONArray categoriesJSON = restaurantJSON.getJSONArray("categories");
//
//                for (int y = 0; y < categoriesJSON.length(); y++) {
//                    categories.add(categoriesJSON.getJSONObject(y).getString("title"));
//                }
//                Restaurant restaurant = new Restaurant(name, phone, website, rating,
//                        imageUrl, address, latitude, longitude, categories);
//                restaurants.add(restaurant);
//            }
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        catch (JSONException e){
//            e.printStackTrace();
//        }
//        return restaurants;
//    }