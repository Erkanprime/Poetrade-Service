package se.nylander.webscraper.model.request;

/**
 * Created by erik.nylander on 2016-04-28.
 */
public class ParameterRequest {
    private String name;
    private Double minValue;
    private Double maxValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }
}
