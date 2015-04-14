package me.leolin.data.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * @author leolin
 */
@Embeddable
public class StockTodayPriceId implements Serializable {
    private String id;
    private Date time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockTodayPriceId that = (StockTodayPriceId) o;

        if (!id.equals(that.id)) return false;
        return time.equals(that.time);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + time.hashCode();
        return result;
    }
}