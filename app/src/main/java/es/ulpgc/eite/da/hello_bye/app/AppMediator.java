package es.ulpgc.eite.da.hello_bye.app;


import es.ulpgc.eite.da.hello_bye.hello.HelloState;

public class AppMediator {

    private static AppMediator INSTANCE;
    private HelloState helloState;
    private HelloToByeState helloToByeState;
    private ByeToHelloState byeToHelloState;

    private AppMediator() {
        //helloState = new HelloState();
        //byeState = new ByeState();
    }

    public static void resetInstance() {
        INSTANCE = null;
    }


    public static AppMediator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppMediator();
        }

        return INSTANCE;
    }


    public HelloState getHelloState() {
        return helloState;
    }

    public void setHelloState(HelloState state) {
        this.helloState = state;
    }

    public HelloToByeState getHelloToByeState() {
        HelloToByeState state = helloToByeState;
        helloToByeState = null;
        return state;
    }

    public void setHelloToByeState(HelloToByeState state) {
        helloToByeState = state;
    }

    public ByeToHelloState getByeToHelloState() {
        ByeToHelloState state = byeToHelloState;
        byeToHelloState = null;
        return state;
    }

    public void setByeToHelloState(ByeToHelloState state) {
        byeToHelloState = state;
    }


}
