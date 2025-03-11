package es.ulpgc.eite.da.hello_bye.bye;

import java.lang.ref.WeakReference;

import android.util.Log;

import es.ulpgc.eite.da.hello_bye.app.AppMediator;
import es.ulpgc.eite.da.hello_bye.app.ByeToHelloState;
import es.ulpgc.eite.da.hello_bye.app.HelloToByeState;

public class ByePresenter implements ByeContract.Presenter {

    public static String TAG = "Hello-Bye.ByePresenter";

    private WeakReference<ByeContract.View> view;
    private AppMediator mediator;
    private ByeContract.Model model;
    private ByeState state;

    public ByePresenter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void onCreateCalled() {
        Log.e(TAG, "onCreateCalled()");

        state = new ByeState();
        mediator.setByeState(state);


        }

    @Override
    public void onRecreateCalled() {
        Log.e(TAG, "onRecreateCalled()");

        state = mediator.getByeState();
    }

    @Override
    public void onResumeCalled() {
        Log.e(TAG, "onResumeCalled()");


        HelloToByeState savedState = mediator.getHelloToByeState();
        if (savedState != null) {

            state.byeMessage = savedState.message;


        }

        // call the model and initialize the state
        view.get().displayByeData(state);

    }

    @Override
    public void onBackButtonPressed() {
        Log.e(TAG, "onBackButtonPressed()");

    }

    @Override
    public void onPauseCalled() {
        Log.e(TAG, "onPauseCalled()");

        mediator.setByeState(state);
    }

    @Override
    public void onDestroyCalled() {
        Log.e(TAG, "onDestroyCalled()");
    }
    @Override
    public void sayByeButtonClicked() {
        Log.e(TAG, "sayByeButtonClicked");

        // call the model
        state.byeMessage = model.getByeMessage();

        // update the view
        view.get().displayByeData(state);
    }
    @Override
    public void goHelloButtonClicked() {
        Log.e(TAG, "goHelloButtonClicked");

        ByeToHelloState newState = new ByeToHelloState(state.byeMessage);
        mediator.setByeToHelloState(newState);

        view.get().navigateToHelloScreen();
    }
    @Override
    public void injectView(WeakReference<ByeContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ByeContract.Model model) {
        this.model = model;
    }

}