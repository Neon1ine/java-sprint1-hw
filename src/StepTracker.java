public class StepTracker {
    static int stepPerDayAim = 10000;
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
                steps[i] = 0;
            }
        }
    }

    static StepTracker stepTracker = new StepTracker();

    public static void changeStepsIn1Day() {
        int month = Main.readMonth();
        int day = Main.readDay();
        int steps = Main.readSteps();
        stepTracker.monthToData[month - 1].steps[day - 1] = steps;
    }

    public static int findStepsFor1Day(int month, int day) {
        return stepTracker.monthToData[month - 1].steps[day - 1];
    }

    public static int findSumSteps(int month) {
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            sum += stepTracker.monthToData[month - 1].steps[i];
        }
        return sum;
    }

    public static int findMaxSteps(int month) {
        int max = -1;
        for (int day = 0; day < 30; day++) {
            if (max < stepTracker.monthToData[month - 1].steps[day]) {
                max = stepTracker.monthToData[month - 1].steps[day];
            }
        }
        return max;
    }

    public static int findAverageSteps(int stepsSum) {
        return stepsSum/30;
    }

    public static double findDistance(int stepsSum) {
        return Converter.stepToKm(stepsSum);
    }

    public static double findCalories(int stepsSum) {
        return Converter.stepToKCalories(stepsSum);
    }

    public static double findBestEpisode(int month) {
        int daysInARow = 0;
        int count = 0;
        for (int i = 0; i < 30; i++) {
            if (stepTracker.monthToData[month - 1].steps[i] >= stepPerDayAim) {
                count++;
            } else {
                if (daysInARow < count) daysInARow = count;
                count = 0;
            }
        }
        return daysInARow;
    }

    public static void changeAimSteps() {
        StepTracker.stepPerDayAim = Main.readSteps();
    }


}
