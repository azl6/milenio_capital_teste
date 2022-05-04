package com.azold6.m_capital.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String convertSystemTimeMillisToString(Long systemMillis){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date resultDate = new Date(systemMillis);
        return sdf.format(resultDate);
    }
}
