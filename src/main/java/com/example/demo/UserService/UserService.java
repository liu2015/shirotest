package com.example.demo.UserService;

import com.example.demo.entity.Usershiro;
import com.example.demo.mapper.UsershiroMapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UsershiroMapper  usershiroMapper;


    @SelectProvider(type=BaseSelectProvider.class, method="dynamicSQL")
    public List<Usershiro> select(Usershiro usershiro) {
        return usershiroMapper.select( usershiro );
    }

    public Usershiro findUser(Usershiro usershiro) {
        return usershiroMapper.findUser( usershiro );
    }
}
