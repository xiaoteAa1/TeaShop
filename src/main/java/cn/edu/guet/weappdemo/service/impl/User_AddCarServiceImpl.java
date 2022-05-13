package cn.edu.guet.weappdemo.service.impl;


import cn.edu.guet.weappdemo.dao.User_AddCar;
import cn.edu.guet.weappdemo.dao.impl.User_AddCarImpl;
import cn.edu.guet.weappdemo.domain.CarTea;
import cn.edu.guet.weappdemo.service.User_AddCarService;


import java.util.List;

/**
 * @author WGJ
 * @date 2022/05/03 12:32
 */
public class User_AddCarServiceImpl implements User_AddCarService {
    User_AddCar user_addCar= new User_AddCarImpl();


    @Override
    public List<CarTea> getTea() {
        List<CarTea> tea = user_addCar.getTea();

        return tea;
    }

    @Override
    public boolean addTea(CarTea carTea) {
        boolean addTea=user_addCar.addTea(carTea);
        return addTea;
    }

    @Override
    public List<CarTea> getCarTea() {
        List<CarTea> tea = user_addCar.getCarTea();

        return tea;
    }
    @Override
    public List<CarTea> getCarTea1() {
        List<CarTea> tea = user_addCar.getCarTea1();
        return tea;
    }

    @Override
    public double getSumPrice() {
        double price=user_addCar.getSumPrice();
        return price;
    }

    @Override
    public boolean deleteTae(CarTea carTea) {
        boolean deleteTea =user_addCar.deleteTea(carTea);
        return deleteTea;
    }


}
