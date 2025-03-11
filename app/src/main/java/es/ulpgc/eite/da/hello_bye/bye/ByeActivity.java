package es.ulpgc.eite.da.hello_bye.bye;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import es.ulpgc.eite.da.hello_bye.R;
import es.ulpgc.eite.da.hello_bye.hello.HelloActivity;


public class ByeActivity
        extends AppCompatActivity implements ByeContract.View {

    public static String TAG = "Hello-Bye.ByeActivity";

    private ByeContract.Presenter presenter;

    Button sayByeButton, goHelloButton;

    TextView byeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bye);
        setTitle("Bye Screen");

        initScreen();
        // Log.e(TAG, "onCreate()");

        // do the setup
        ByeScreen.configure(this);

        // init or update the state
        if (savedInstanceState == null) {
            presenter.onCreateCalled();

        } else {
            presenter.onRecreateCalled();
        }
    }

    private void initScreen() {

        sayByeButton = findViewById(R.id.sayByeButton);
        goHelloButton = findViewById(R.id.goHelloButton);
        byeMessage = findViewById(R.id.byeMessage);

        sayByeButton.setText(getSayByeButtonLabel());
        goHelloButton.setText(getGoHelloButtonLabel());

        sayByeButton.setOnClickListener(v -> presenter.sayByeButtonClicked());
        goHelloButton.setOnClickListener(v -> presenter.goHelloButtonClicked());
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Log.e(TAG, "onResume()");

        // load the data
        presenter.onResumeCalled();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // Log.e(TAG, "onBackPressed()");

        presenter.onBackButtonPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Log.e(TAG, "onPause()");

        presenter.onPauseCalled();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Log.e(TAG, "onDestroy()");

        presenter.onDestroyCalled();
    }
    @Override
    public void navigateToHelloScreen(){
    Intent intent = new Intent(this, HelloActivity.class);
    startActivity(intent);
    }

    @Override
    public void displayByeData(ByeViewModel viewModel) {
        Log.e(TAG, "displayByeData");

        // deal with the data
        byeMessage.setText(viewModel.byeMessage);
    }

    private String getGoHelloButtonLabel() {
        return getResources().getString(R.string.go_hello_button_label);
    }

    private String getSayByeButtonLabel() {
        return getResources().getString(R.string.say_bye_button_label);

    }
    @Override
    public void injectPresenter(ByeContract.Presenter presenter) {
        this.presenter = presenter;
    }
}


