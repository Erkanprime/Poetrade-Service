package se.nylander.webscraper.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by erik.nylander on 2016-04-28.
 */
public class SocketRequest {


    private Integer socketMinValue;
    private Integer socketMaxValue;
    private Integer linksMinValue;
    private Integer linksMaxValue;

    public Integer getSocketMinValue() {
        return socketMinValue;
    }

    public void setSocketMinValue(Integer socketMinValue) {
        this.socketMinValue = socketMinValue;
    }

    public Integer getSocketMaxValue() {
        return socketMaxValue;
    }

    public void setSocketMaxValue(Integer socketMaxValue) {
        this.socketMaxValue = socketMaxValue;
    }

    public Integer getLinksMinValue() {
        return linksMinValue;
    }

    public void setLinksMinValue(Integer linksMinValue) {
        this.linksMinValue = linksMinValue;
    }

    public Integer getLinksMaxValue() {
        return linksMaxValue;
    }

    public void setLinksMaxValue(Integer linksMaxValue) {
        this.linksMaxValue = linksMaxValue;
    }

}
