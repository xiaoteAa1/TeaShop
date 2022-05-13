package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.dao.Business_LoginDao;
import cn.edu.guet.weappdemo.dao.impl.Business_LoginDaoImpl;
import cn.edu.guet.weappdemo.service.Business_LoginService;

public class Business_LoginServiceImpl implements Business_LoginService {
    private Business_LoginDao bld = new Business_LoginDaoImpl();
    @Override
    public boolean login(String username, String password) {
        return bld.login(username,password);
    }
}
