package by.rimza.model;

import java.util.Date;

public class Currency {

    private int cur_id;
    private Date date;
    private String cur_abbreviation;
    private String cur_name;
    private double cur_officialRate;

    public Currency() {

    }

    public Currency(int cur_id, Date date, String cur_abbreviation, String cur_name, double cur_officialRate) {
        this.cur_id = cur_id;
        this.date = date;
        this.cur_abbreviation = cur_abbreviation;
        this.cur_name = cur_name;
        this.cur_officialRate = cur_officialRate;
    }

    public int getCur_id() {
        return cur_id;
    }

    public void setCur_id(int cur_id) {
        this.cur_id = cur_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCur_abbreviation() {
        return cur_abbreviation;
    }

    public void setCur_abbreviation(String cur_abbreviation) {
        this.cur_abbreviation = cur_abbreviation;
    }

    public String getCur_name() {
        return cur_name;
    }

    public void setCur_name(String cur_name) {
        this.cur_name = cur_name;
    }

    public double getCur_officialRate() {
        return cur_officialRate;
    }

    public void setCur_officialRate(double cur_officialRate) {
        this.cur_officialRate = cur_officialRate;
    }
}
