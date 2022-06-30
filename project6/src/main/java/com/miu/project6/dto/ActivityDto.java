package com.miu.project6.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDto {
    private int id;
    private Date date;
    private String operation;
    private long duration;

    public ActivityDto(Date date, String operation, long duration){
        this.date=date;
        this.operation=operation;
        this.duration=duration;
    }
}
