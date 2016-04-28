package se.nylander.webscraper.model.request;

/**
 * Created by erik.nylander on 2016-04-28.
 */
public class SocketRequest {

    private Double socketMinValue;
    private Double socketMaxValue;
    private Double linksMinValue;
    private Double linksMaxValue;

    public Double getSocketMinValue() {
        return socketMinValue;
    }

    public void setSocketMinValue(Double socketMinValue) {
        this.socketMinValue = socketMinValue;
    }

    public Double getSocketMaxValue() {
        return socketMaxValue;
    }

    public void setSocketMaxValue(Double socketMaxValue) {
        this.socketMaxValue = socketMaxValue;
    }

    public Double getLinksMinValue() {
        return linksMinValue;
    }

    public void setLinksMinValue(Double linksMinValue) {
        this.linksMinValue = linksMinValue;
    }

    public Double getLinksMaxValue() {
        return linksMaxValue;
    }

    public void setLinksMaxValue(Double linksMaxValue) {
        this.linksMaxValue = linksMaxValue;
    }
}
