package com.example.retrfoit_json.api;

import com.example.retrfoit_json.model.MonthModel;

public class MonthResponse {
    private MonthModel[] months;

    public MonthResponse(MonthModel[] months) {
        this.months = months;
    }

    public MonthModel[] getMonths(){
        return months;
    }
}
