package es.ulpgc.eite.da.hello_bye.bye;

import android.util.Log;

public class ByeModel implements ByeContract.Model {

    public static String TAG = "Hello-Bye.ByeModel";

    private String message;

    public ByeModel(String message) {
        this.message = message;
    }

    @Override
    public String getByeMessage() {
        return message;
    }
}
