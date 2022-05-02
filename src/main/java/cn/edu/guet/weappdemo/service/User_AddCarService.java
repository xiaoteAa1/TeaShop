package cn.edu.guet.weappdemo.service;



import cn.edu.guet.weappdemo.domain.CarTea;

import java.util.List;

/**
 * @author WGJ
 * @date 2022/05/01 22:00
 */
public interface User_AddCarService {
    List<CarTea> getTea();
    boolean addTea(CarTea carTea);
    List<CarTea> getCarTea();
    double getSumPrice();
}
