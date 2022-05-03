package cn.edu.guet.weappdemo.service;


import cn.edu.guet.weappdemo.domain.CarTea;

import java.util.List;

public interface User_AddCarService {
    List<CarTea> getTea();
    boolean addTea(CarTea carTea);
    List<CarTea> getCarTea();
    double getSumPrice();
}
