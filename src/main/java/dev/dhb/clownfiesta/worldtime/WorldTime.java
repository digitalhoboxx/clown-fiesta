package dev.dhb.clownfiesta.worldtime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table
//needed (to not return client_ip) in this implementation
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorldTime {
    @Id
    @SequenceGenerator(
            name = "worldtime_sequence",
            sequenceName = "worldtime_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "worldtime_sequence"
    )
    private Long id;
    private String abbreviation;
    private String client_ip;
    private String datetime;
    private Integer day_of_week; //where Sunday = 0
    private Integer day_of_year;
    private boolean dst;
    private String dst_from;
    private Integer dst_offset;
    private String dst_until;
    private Integer raw_offset;
    private String timezone;
    private Integer unixtime;
    private String  utc_datetime;
    private String utc_offset;
    private Integer week_number;

    public WorldTime() {
    }

    public WorldTime(String abbreviation, String client_ip, String datetime, Integer day_of_week, Integer day_of_year, boolean dst, String dst_from, Integer dst_offset, String dst_until, Integer raw_offset, String timezone, Integer unixtime, String utc_datetime, String utc_offset, Integer week_number) {
        this.abbreviation = abbreviation;
        this.client_ip = client_ip;
        this.datetime = datetime;
        this.day_of_week = day_of_week;
        this.day_of_year = day_of_year;
        this.dst = dst;
        this.dst_from = dst_from;
        this.dst_offset = dst_offset;
        this.dst_until = dst_until;
        this.raw_offset = raw_offset;
        this.timezone = timezone;
        this.unixtime = unixtime;
        this.utc_datetime = utc_datetime;
        this.utc_offset = utc_offset;
        this.week_number = week_number;
    }

    public WorldTime(Long id, String abbreviation, String client_ip, String datetime, Integer day_of_week, Integer day_of_year, boolean dst, String dst_from, Integer dst_offset, String dst_until, Integer raw_offset, String timezone, Integer unixtime, String utc_datetime, String utc_offset, Integer week_number) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.client_ip = client_ip;
        this.datetime = datetime;
        this.day_of_week = day_of_week;
        this.day_of_year = day_of_year;
        this.dst = dst;
        this.dst_from = dst_from;
        this.dst_offset = dst_offset;
        this.dst_until = dst_until;
        this.raw_offset = raw_offset;
        this.timezone = timezone;
        this.unixtime = unixtime;
        this.utc_datetime = utc_datetime;
        this.utc_offset = utc_offset;
        this.week_number = week_number;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(Integer day_of_week) {
        this.day_of_week = day_of_week;
    }

    public Integer getDay_of_year() {
        return day_of_year;
    }

    public void setDay_of_year(Integer day_of_year) {
        this.day_of_year = day_of_year;
    }

    public boolean isDst() {
        return dst;
    }

    public void setDst(boolean dst) {
        this.dst = dst;
    }

    public String getDst_from() {
        return dst_from;
    }

    public void setDst_from(String dst_from) {
        this.dst_from = dst_from;
    }

    public Integer getDst_offset() {
        return dst_offset;
    }

    public void setDst_offset(Integer dst_offset) {
        this.dst_offset = dst_offset;
    }

    public String getDst_until() {
        return dst_until;
    }

    public void setDst_until(String dst_until) {
        this.dst_until = dst_until;
    }

    public Integer getRaw_offset() {
        return raw_offset;
    }

    public void setRaw_offset(Integer raw_offset) {
        this.raw_offset = raw_offset;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(Integer unixtime) {
        this.unixtime = unixtime;
    }

    public String getUtc_datetime() {
        return utc_datetime;
    }

    public void setUtc_datetime(String utc_datetime) {
        this.utc_datetime = utc_datetime;
    }

    public String getUtc_offset() {
        return utc_offset;
    }

    public void setUtc_offset(String utc_offset) {
        this.utc_offset = utc_offset;
    }

    public Integer getWeek_number() {
        return week_number;
    }

    public void setWeek_number(Integer week_number) {
        this.week_number = week_number;
    }

    @Override
    public String toString() {
        return "WorldTime{" +
                "abbreviation='" + abbreviation + '\'' +
                ", datetime='" + datetime + '\'' +
                ", day_of_week=" + day_of_week +
                ", day_of_year=" + day_of_year +
                ", dst=" + dst +
                ", dst_from='" + dst_from + '\'' +
                ", dst_offset=" + dst_offset +
                ", dst_until='" + dst_until + '\'' +
                ", raw_offset=" + raw_offset +
                ", timezone='" + timezone + '\'' +
                ", unixtime=" + unixtime +
                ", utc_datetime='" + utc_datetime + '\'' +
                ", utc_offset='" + utc_offset + '\'' +
                ", week_number=" + week_number +
                '}';
    }
}
