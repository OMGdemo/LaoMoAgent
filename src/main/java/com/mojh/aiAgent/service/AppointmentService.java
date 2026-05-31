package com.mojh.aiAgent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mojh.aiAgent.bean.Appointment;

public interface AppointmentService extends IService<Appointment> {

    Appointment getOne(Appointment appointment);

}
