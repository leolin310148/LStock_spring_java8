package me.leolin.model.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author leolin
 */
@Entity
public class StockEntity implements Serializable{
    @Id
    private String id;
    @Column
    private String ex;
    @Column
    private String fullName;
    @Column
    private String name;
    @Column
    private String industryCode;

    public StockEntity() {
    }

    public StockEntity(String id, String ex, String fullName, String name, String industryCode) {
        this.id = id;
        this.ex = ex;
        this.fullName = fullName;
        this.name = name;
        this.industryCode = industryCode;
    }

    public StockEntity(String id, String ex, String fullName, String name) {
        this.id = id;
        this.ex = ex;
        this.fullName = fullName;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
