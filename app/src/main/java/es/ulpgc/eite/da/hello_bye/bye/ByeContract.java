package es.ulpgc.eite.da.hello_bye.bye;

import java.lang.ref.WeakReference;

public interface ByeContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayByeData(ByeViewModel viewModel);

        void navigateToHelloScreen();


    }

    interface Presenter {
        void sayByeButtonClicked();

        void goHelloButtonClicked();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void onResumeCalled();

        void onCreateCalled();

        void onRecreateCalled();

        void onBackButtonPressed();

        void onPauseCalled();

        void onDestroyCalled();
    }

    interface Model {
        String getByeMessage();
    }

}
