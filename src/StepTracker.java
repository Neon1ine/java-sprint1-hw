public class StepTracker {
    int stepPerDayAim = 10000;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] steps = new int[30];
        public MonthData() {
            for (int i = 0; i < steps.length; i++) {
                steps[i] = 2000;
            }
        }
    }

    static StepTracker stepTracker = new StepTracker();

    public static int findStepsFor1Day() {
        int month = Main.readMonth();
        int day = Main.readDay();
        return stepTracker.monthToData[month - 1].steps[day - 1];
    }
}
