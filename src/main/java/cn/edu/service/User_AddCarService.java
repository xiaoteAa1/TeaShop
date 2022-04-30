package cn.edu.service;

import cn.edu.domain.CarTea;

import java.util.List;

public interface User_AddCarService {
    List<CarTea> getTea();
    boolean addTea(CarTea carTea);
    List<CarTea> getCarTea();
}
