package com.example.extellar.mycurrenttask.JsonParser;

import android.util.Log;

import com.example.extellar.mycurrenttask.m_Realm.RealmHelper;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;

public class MyAsyncTask extends android.os.AsyncTask<Void, Void, Void> {


    private String TAG = getClass().getSimpleName();
    private Realm realm;
    private RealmHelper realmHelper;

    private final String url = "https://jsonplaceholder.typicode.com/posts";
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("TAG", "I am starting parsing!");

    }

    @Override
    protected Void doInBackground(Void... voids) {
        // Making a request to url and getting response
        HttpHandler hh = new HttpHandler();
        String jsonString = hh.makeServiceCall(url);
        try

        {
            Log.e(getClass().getSimpleName(), "АСИНХРОННЫЙ");
            JSONArray jsonarray = new JSONArray(jsonString);
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);

                int userId = Integer.parseInt(jsonobject.getString("userId"));
                int id = Integer.parseInt(jsonobject.getString("id"));
                String title = jsonobject.getString("title");
                String body = jsonobject.getString("body");
                Log.d(TAG, "[" + userId + " " + id + "]");

                //save object to REALM
                realmHelper = new RealmHelper(realm);
                realmHelper.realm_save(userId, id, title, body);
            }
        } catch (
                JSONException j)

        {
            j.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        Log.d(TAG, "I have already finished!");
    }

}
