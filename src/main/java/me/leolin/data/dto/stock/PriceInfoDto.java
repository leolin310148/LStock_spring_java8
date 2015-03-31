package me.leolin.data.dto.stock;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author leolin
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PriceInfoDto {
    private String count;
    private String price;
    private String color;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
