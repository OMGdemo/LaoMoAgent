package com.mojh.aiAgent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mojh.aiAgent.bean.Appointment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppointmentMapper extends BaseMapper<Appointment> {
}