package kr.ac.mjc.hotel.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;


@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Reservation {

    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "res_f_date", nullable = false)
    private java.sql.Date res_f_date;

    @Column(name = "res_e_date", nullable = false)
    private java.sql.Date res_e_date;

    @Column(name = "adult_num", updatable = false)
    private int adult_num;

    @Column(name = "child_num", updatable = false)
    private int child_num;

    @Column(name = "request", updatable = false)
    private String request;

    @ManyToOne
    @JoinColumn(name = "rester_id")
    private User rester;


    // 다른 생성자 로직 또는 초기화 로직
    public Reservation(java.sql.Date res_f_date, java.sql.Date res_e_date, int adult_num, int child_num, String request, User rester) {
        this.res_f_date = res_f_date;
        this.res_e_date = res_e_date;
        this.adult_num = adult_num;
        this.child_num = child_num;
        this.request = request;
        this.rester = rester;

        // 다른 생성자 로직 또는 초기화 로직
    }

    public Reservation(){}

    public Reservation(Date resFDate, Date resEDate, int adultNum, int childNum, String request, String roomType) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRes_f_date() {
        return res_f_date;
    }

    public void setRes_f_date(Date res_f_date) {
        this.res_f_date = res_f_date;
    }

    public Date getRes_e_date() {
        return res_e_date;
    }

    public void setRes_e_date(Date res_e_date) {
        this.res_e_date = res_e_date;
    }

    public int getAdult_num() {
        return adult_num;
    }

    public void setAdult_num(int adult_num) {
        this.adult_num = adult_num;
    }

    public int getChild_num() {
        return child_num;
    }

    public void setChild_num(int child_num) {
        this.child_num = child_num;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public User getRester() {
        return rester;
    }

    public void setRester(User rester) {
        this.rester = rester;
    }


}
