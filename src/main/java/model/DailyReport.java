package model;

import org.hibernate.Session;

import javax.persistence.*;

@Entity
@Table(name = "daily_reports")
public class DailyReport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "earnings")
    private long earnings;

    @Column(name = "soldCars")
    private Long soldCars;

    public DailyReport() {

    }

    public DailyReport(long earnings, Long soldCars) {
        this.earnings = earnings;
        this.soldCars = soldCars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getEarnings() {
        return earnings;
    }

    public void setEarnings(long earnings) {
        this.earnings = earnings;
    }

    public Long getSoldCars() {
        return soldCars;
    }

    public void setSoldCars(Long soldCars) {
        this.soldCars = soldCars;
    }
}
