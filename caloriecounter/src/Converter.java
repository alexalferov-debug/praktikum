public class Converter {

    final static int centimetersInOneStep = 78;
    final static int centimetersInMeter = 100;
    final static int metersInKillometer = 1000;
    final static double kilocaloriesInOneStep = 0.05;

    static int convertToKm(int steps){
        return (int) (steps*((double)centimetersInOneStep/centimetersInMeter)/metersInKillometer);
    }

    static int convertStepsToKilocalories(int steps){
        return (int) (steps*kilocaloriesInOneStep);
    }
}
