package cn.edu.dao;

import cn.edu.domain.CarTea;

import java.util.List;

public interface User_AddCar {
    List<CarTea> getTea();

    boolean addTea(CarTea carTea);

    List<CarTea> getCarTea();
}
