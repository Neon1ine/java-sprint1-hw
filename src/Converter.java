public class Converter {
    public static double stepToKm(int step){
        return (step * 0.75) / 1000;
    }

    public static double stepToKCalories(int step){
        return (step * 50) / 1000;
    }
}
