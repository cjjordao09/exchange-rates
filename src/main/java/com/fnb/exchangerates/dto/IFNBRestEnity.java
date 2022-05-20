package com.fnb.exchangerates.dto;

import java.time.LocalDateTime;

public interface IFNBRestEnity {

    String getResult();

    String getProvider();

    LocalDateTime getDateTime();
}
