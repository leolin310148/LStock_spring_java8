package me.leolin.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author leolin
 */
@Entity
public class SubscribeGroupEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;

    @Column
    private String name;

    @OneToMany
    private List<SubscribeStockEntity> subscribeStocks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubscribeStockEntity> getSubscribeStocks() {
        return subscribeStocks;
    }

    public void setSubscribeStocks(List<SubscribeStockEntity> subscribeStocks) {
        this.subscribeStocks = subscribeStocks;
    }
}
