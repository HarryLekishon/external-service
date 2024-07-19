package com.restemplate.countryapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse {
    private boolean error;
    private String msg;
    private List<Countries> data;
}
