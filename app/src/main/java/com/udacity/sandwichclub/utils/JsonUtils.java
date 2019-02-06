package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich model = new Sandwich();

        try {
           JSONObject sandwichDetails = new JSONObject(json);
           JSONObject nameDetails = sandwichDetails.optJSONObject("name");
           JSONArray alsoKnownAs = nameDetails.optJSONArray("alsoKnownAs");
           JSONArray ingredients = sandwichDetails.optJSONArray("ingredients");

           model.setMainName(nameDetails.getString("mainName"));
           model.setAlsoKnownAs(JSONArrayToList(alsoKnownAs));
           model.setPlaceOfOrigin(sandwichDetails.getString("placeOfOrigin"));
           model.setDescription(sandwichDetails.getString("description"));
           model.setImage(sandwichDetails.getString("image"));
           model.setIngredients(JSONArrayToList(ingredients));
        } catch (Exception e) {
            return null;
        }

        return model;
    }

    private static List<String> JSONArrayToList(JSONArray JSONArray) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        if (JSONArray != null) {
            for (int i=0; i < JSONArray.length(); i++){
                list.add(JSONArray.getString(i));
            }
        }

        return list;
    }
}
