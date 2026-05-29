package com.mojh.aiAgent.service.impl;

import com.mojh.aiAgent.bean.Appointment;
import com.mojh.aiAgent.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    public static Map<String,Appointment> appointmentMap = new HashMap<>();

    /**
     * 查询订单是否存在
     * @param appointment
     * @return
     */
    @Override
    public Appointment getOne(Appointment appointment) {
        return appointmentMap.get(appointment.getDate()+ "_" + appointment.getTime() + "_" + appointment.getUsername());
    }

    @Override
    public Boolean save(Appointment appointment) {
        appointmentMap.put(appointment.getDate()+ "_" + appointment.getTime() + "_" + appointment.getUsername(),appointment);
        return true;
    }

    @Override
    public Boolean remove(Appointment appointment) {
        return appointmentMap.remove(appointment.getDate()+ "_" + appointment.getTime() + "_" + appointment.getUsername()) != null;
    }
}
