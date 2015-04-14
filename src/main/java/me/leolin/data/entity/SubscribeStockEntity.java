package me.leolin.data.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author leolin
 */
@Entity
public class SubscribeStockEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_seq")
    private Integer order;

    @ManyToOne
    @JoinColumn(name = "group_id",referencedColumnName = "id")
    private SubscribeGroupEntity group;

    @OneToOne(targetEntity = StockEntity.class)
    private StockEntity stockEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public SubscribeGroupEntity getGroup() {
        return group;
    }

    public void setGroup(SubscribeGroupEntity group) {
        this.group = group;
    }

    public StockEntity getStockEntity() {
        return stockEntity;
    }

    public void setStockEntity(StockEntity stockEntity) {
        this.stockEntity = stockEntity;
    }
}
