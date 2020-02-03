package java.com.accenture.flowershop.be.entity.flower;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

public class Flowers {
    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private int count;
    private BigDecimal value;

    public Flowers(String name, int count, BigDecimal value) {
        this.name = name;
        this.count = count;
        this.value = value;
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
