package com.example.demo.mapper;

import com.example.demo.entity.Usershiro;
import mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsershiroMapper extends MyMapper<Usershiro> {

    public Usershiro findUser(Usershiro usershiro);
}