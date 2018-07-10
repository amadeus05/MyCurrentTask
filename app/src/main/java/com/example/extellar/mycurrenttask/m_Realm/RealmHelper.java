package com.example.extellar.mycurrenttask.m_Realm;

import android.util.Log;

import com.example.extellar.mycurrenttask.Tamplate;


import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {

    private final String TAG = getClass().getSimpleName();

    Realm realm;

    public RealmHelper(Realm realm){
        this.realm = realm;
    }

    public void realm_save(final int userId, final int id, final String title, final String content) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Tamplate tamplate = realm.createObject(Tamplate.class);
            tamplate.setUserId(userId);
            tamplate.setPostId(id);
            tamplate.setTitle(title);
            tamplate.setContent(content);
        realm.commitTransaction();

    }

    public void retrieve() {
        RealmResults<Tamplate> tamplates = realm.where(Tamplate.class).findAll();
        realm.beginTransaction();
        for (Tamplate realmTamplate : tamplates) {
            Log.d(TAG, "ISSSSSS - " + realmTamplate.getPostId());
        }

        realm.commitTransaction();
    }

    public void clearDB(){
        RealmResults<Tamplate> tamplates = realm.where(Tamplate.class).findAll();
        realm.beginTransaction();
        tamplates.deleteAllFromRealm();
        realm.commitTransaction();
    }
}
