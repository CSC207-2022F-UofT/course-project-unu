package entities.cards;

import useCases.Presenter_Interface;

public class ColourChange_UseCaseInteractor {

    /*
    Should depend on the Presenter_Interface, but where does this object come from?
    Does it just create a new one? How is that object connected to our view model?
     */
    Presenter_Interface presenter;

    ColourChange_UseCaseInteractor(Presenter_Interface presenter) {
        this.presenter = presenter;
    }
    public void requestColourChange() {
        presenter.requestNewColour();
    }
}
