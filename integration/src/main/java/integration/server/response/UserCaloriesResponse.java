package integration.server.response;


public class UserCaloriesResponse {

    private int year;

    private String month;

    private int caloriesGained;

    private int caloriesConsumed;

    private int caloriesBalance;


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getCaloriesGained() {
        return caloriesGained;
    }

    public void setCaloriesGained(int caloriesGained) {
        this.caloriesGained = caloriesGained;
    }

    public int getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(int caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }

    public int getCaloriesBalance() {
        return caloriesBalance;
    }

    public void setCaloriesBalance(int caloriesBalance) {
        this.caloriesBalance = caloriesBalance;
    }

}
