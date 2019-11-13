package sell_statistics;

public class SellStatisticInput {
    private StatisticEnum type;
    private int startDay;
    private int endDay;
    private int productId;
    private int categoryId;
    private int stateId;
    private int regionId;

    public SellStatisticInput(StatisticEnum type, int startDay, int endDay, int productId, int categoryId, int stateId, int regionId) {
        this.type = type;
        this.startDay = startDay;
        this.endDay = endDay;
        this.productId = productId;
        this.categoryId = categoryId;
        this.stateId = stateId;
        this.regionId = regionId;
    }

    public StatisticEnum getType() {
        return type;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public int getProductId() {
        return productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getStateId() {
        return stateId;
    }

    public int getRegionId() {
        return regionId;
    }

    @Override
    public String toString() {
        return "SellStatisticInput{" +
                "type=" + type +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", productId=" + productId +
                ", categoryId=" + categoryId +
                ", stateId=" + stateId +
                ", regionId=" + regionId +
                '}';
    }
}
