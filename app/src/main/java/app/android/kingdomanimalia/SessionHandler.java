package app.android.kingdomanimalia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by Unknown on 28/04/2016.
 */
public class SessionHandler {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "kingdomanimalia";

    // All Shared Preferences Keys
    private static final String IS_FIRST = "isFirstTime";
    private static final String INDEX_SOAL = "INDEX_SOAL";
    private static final String isOneDone = "isOneDone";
    private static final String rateOne = "rateOne";
    private static final String rateTwo = "rateTwo";


    // Constructor
    public SessionHandler(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create regis session
     * */

    public void createOneDone(){
        editor.putBoolean(isOneDone, true);

        editor.commit();
    }

    public void createOneFalse(){
        editor.putBoolean(isOneDone, false);

        editor.commit();
    }

    public void createRateOne(int rate){
        editor.putInt(rateOne, rate);

        editor.commit();
    }

    public void createRateTwo(int rate){
        editor.putInt(rateTwo, rate);

        editor.commit();
    }

    public void createFirstTimeSession() {
        // Storing login value as TRUE
        editor.putBoolean(IS_FIRST, true);

        // commit changes
        editor.commit();
    }

    public void addIndexSoal(int count){
        editor.putInt(INDEX_SOAL, getIndexSoal() + count);

        editor.commit();
    }

    /**
     * Check login method wil check user login status If false it will redirect
     * user to login page Else won't do anything
     * */
    public void checkFirstTimeSession() {
        // Check login status
        if (this.isFirstTime()) {

            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, MenuActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isOneDone(){ return pref.getBoolean(isOneDone, false); }

    public int getRateOne(){
        return pref.getInt(rateOne, 1);
    }

    public int getRateTwo(){
        return pref.getInt(rateTwo, 1);
    }
    public boolean isFirstTime() {
        return pref.getBoolean(IS_FIRST, false);
    }

    public int getIndexSoal() { return pref.getInt(INDEX_SOAL, 0); }
}
