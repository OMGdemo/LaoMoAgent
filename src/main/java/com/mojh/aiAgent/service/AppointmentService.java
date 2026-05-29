package com.mojh.aiAgent.service;

import com.mojh.aiAgent.bean.Appointment;

public interface AppointmentService {

    Appointment getOne(Appointment appointment);

    Boolean save(Appointment appointment);

    Boolean remove(Appointment appointment);
}
