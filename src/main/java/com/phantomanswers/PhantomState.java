package com.phantomanswers;

public class PhantomState {

    private static boolean simulationMode = false;

    private static String selectedLab = "";
    private static String hiddenCode = "";

    private static int codePosition = 0;

    public static boolean isSimulationMode() {
        return simulationMode;
    }

    public static void toggleMode() {
        simulationMode = !simulationMode;
    }

    public static String getSelectedLab() {
        return selectedLab;
    }

    public static boolean hasNextCharacter() {
        return hiddenCode != null
                && codePosition < hiddenCode.length();
    }

    public static char getNextCharacter() {
        char character = hiddenCode.charAt(codePosition);
        codePosition++;
        return character;
    }

    public static void selectLab(int number) {

        if (number < 1 || number > 9) {
            return;
        }

        selectedLab = "Lab " + number;

        hiddenCode = LabRepository.loadLab(number);

        codePosition = 0;

        System.out.println(
                "Loaded " + selectedLab +
                        ", characters: " + hiddenCode.length()
        );
    }
}