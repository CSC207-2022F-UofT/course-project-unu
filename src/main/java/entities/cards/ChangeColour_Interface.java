package entities.cards;

public class ChangeColour_Interface implements ChangeColour{

    @Override
    public String getNewColour() {
        while (true) {
            String newColour = getInput();
            switch (newColour) {
                case "Red":
                case "Green":
                case "Blue":
                case "Yellow":
                    return newColour;
                default:
                    //TODO: Tell presenter this colour is wrong
            }
        }

        /*
        Call controller,
        Get input,
        Check if input is good,
        Repeat until input is good,
        Return input.
         */
    }

    private String getInput() {
        //TODO: Get controller input here
        return null;
    }
}
