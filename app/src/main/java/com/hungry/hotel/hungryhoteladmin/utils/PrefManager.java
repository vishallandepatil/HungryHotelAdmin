package com.hungry.hotel.hungryhoteladmin.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class PrefManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    public static int PRIVATE_MODE = 0;

    // Shared preferences file name
    public static final String PREF_NAME = "hungryhoteladmin";

    // All Shared Preferences Keys

    private static final String IS_LOGIN = "islogin";
    private static final String ROLEID = "roleid";
    private static final String USERID = "userid";
    private static final String FNAME = "fname";
    private static final String ADDRESS = "address";
    private static final String MOBILE = "mobile";


    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setIS_LOGIN(boolean login) {
        editor.putBoolean(IS_LOGIN, login);
        editor.commit();
    }

    public boolean getIS_LOGIN() {
        return pref.getBoolean(IS_LOGIN, false);
    }

       public void setROLEID(int login) {
            editor.putInt(ROLEID, login);
            editor.commit();
        }

        public int getROLEID() {
            return pref.getInt(ROLEID, 0);
        }

         public void setUSERID(int userid) {
                    editor.putInt(USERID, userid);
                    editor.commit();
                }

         public int getUSERID() {
                    return pref.getInt(USERID, 0);
                }

           public void setFNAME(String name)
           {
                editor.putString(FNAME, name);
                editor.commit();
           }
           public String getFNAME()
           {
                return pref.getString(FNAME, null);
           }

           public void setADDRESS(String address)
           {
                editor.putString(ADDRESS, address);
                editor.commit();
           }
           public String getADDRESS()
           {
                return pref.getString(ADDRESS, null);
           }

           public void setMOBILE(String mobile)
           {
                editor.putString(MOBILE, mobile);
                editor.commit();
           }
           public String getMOBILE()
           {
                return pref.getString(MOBILE, null);
           }


}
