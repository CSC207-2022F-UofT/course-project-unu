package interfaceAdapters;

import UI.View;

public class Presenter implements Presenter_Interface {

    View viewMethods;
    /*
     Based on the MVC model, this Presenter class should depend on a View Interface.
     Where it gets it I have no idea (yet).
     */

    public Presenter(View view) {
        viewMethods = view;
    }
    @Override
    public void requestNewColour() {
        viewMethods.requestColourChange();
        /*
        Calls a View Interface and a method in it.
         */
    }

}
