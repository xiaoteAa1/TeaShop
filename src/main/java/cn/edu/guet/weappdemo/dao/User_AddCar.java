package cn.edu.guet.weappdemo.dao;

import cn.edu.guet.weappdemo.domain.CarTea;

import java.util.List;

/**
 * @author WGJ
 * @date 2022/05/03 12:32
 */
public interface User_AddCar {
    List<CarTea> getTea();

    boolean addTea(CarTea carTea);

    List<CarTea> getCarTea();

    double getSumPrice();

    boolean deleteTea(CarTea carTea);
}
