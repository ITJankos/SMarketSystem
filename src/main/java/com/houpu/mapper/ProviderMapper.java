package com.houpu.mapper;

import com.houpu.domain.Provider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProviderMapper {

    List<Provider> findAll(@Param("proCode") String proCode, @Param("proName") String proName);

    int findTotlCount();

    void save(Provider provider);

    @Select("select * from t_provider where id=#{id}")
    Provider findById(String id);

    void update(Provider provider);

    @Delete("delete from t_provider where id=#{id}")
    void delete(String id);

    @Select("select * from t_provider ")
    List<Provider> findAllProvider();
}
