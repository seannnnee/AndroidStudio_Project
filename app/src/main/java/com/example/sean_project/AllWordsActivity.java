package com.example.sean_project;

import android.app.ProgressDialog;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


public class AllWordsActivity extends ListActivity {

    ArrayList<HashMap<String, String>> WordsList;

    private ProgressDialog pDialog;

    // url to get all products list
    private static String url_all_words = MainActivity.ipBaseAddress+"/get_all_WordsJson.php";
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_WORDS = "Words";
    private static final String TAG_PID = "pid";

    // products JSONArray
    JSONArray Words = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_words);

        //   Log.i("------url_all_products",url_all_products);
        // Hashmap for ListView
        WordsList = new ArrayList<HashMap<String, String>>();

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading product ...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();

        // Loading products in Background Thread
        postData(url_all_words,null );

        // Get listview from list_items.xml
        ListView lv = getListView();

        // on seleting single product
        // launching Edit Product Screen
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem

                // Starting new intent

                // sending pid to next activity


                // starting new activity and expecting some response back

            }
        });

    }

    // Response from Edit Product Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // if result code 100 means Continue
        //https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html

        if (resultCode == 100) {
            // if result code 100 is received
            // means user edited/deleted product
            // reload this screen again
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

    }

    public void postData(String url, final JSONObject json){
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest json_obj_req = new JsonObjectRequest(
                Request.Method.POST, url, json, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                checkResponse(response, json);

//                String alert_message;
//                alert_message = response.toString();

//                showAlertDialogue("Response", alert_message);

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

//                String alert_message;
//                alert_message = error.toString();

//                showAlertDialogue("Error", alert_message);

            }

        });

        requestQueue.add(json_obj_req);
    }

    private void checkResponse(JSONObject response, JSONObject creds){
        try {
            if(response.getInt(TAG_SUCCESS)==1){

                // products found
                // Getting Array of Products
                Words = response.getJSONArray(TAG_WORDS);

                // looping through All Products
                for (int i = 0; i < Words.length(); i++) {
                    JSONObject c = Words.getJSONObject(i);

                    // Storing each json item in variable
                    String pid = c.getString(TAG_PID);
                    String Words = c.getString(TAG_WORDS);

                    // creating new HashMap
                    HashMap<String, String> map = new HashMap<String, String>();

                    // adding each child node to HashMap key => value
                    map.put(TAG_PID, pid);
                    map.put(TAG_WORDS, Words);

                    // adding HashList to ArrayList
                    WordsList.add(map);
                }

                /**
                 * Updating parsed JSON data into ListView
                 * */
                ListAdapter adapter = new SimpleAdapter(
                        AllWordsActivity.this, WordsList,
                        R.layout.list_item, new String[] { TAG_PID,
                        TAG_WORDS},
                        new int[] { R.id.pid, R.id.Words });
                // updating listview
                setListAdapter(adapter);

            }
            else{

            }

        } catch (JSONException e) {
            e.printStackTrace();

        }


        pDialog.dismiss();

    }

} //end of AllWordsActivity class
