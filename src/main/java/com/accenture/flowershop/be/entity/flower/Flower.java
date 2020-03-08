package com.accenture.flowershop.be.entity.flower;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Flowers")
@Table(name = "TB_FLOWERS")
public class Flower {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "sequenceId")
    @SequenceGenerator(name = "sequenceId", sequenceName = "flower_sg", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNT")
    private int count;

    @Column(name = "VALUE")
    private BigDecimal value;

    public Flower() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
