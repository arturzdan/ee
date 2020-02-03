package java.com.accenture.flowershop.be.entity.flower;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Flowers {
    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private int count;
    private double value;
}
