package com.houpu.mapper;

import com.houpu.domain.Bill;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BilMapper {
    @Delete("delete from t_bill where providerId=#{pid}")
    void deleteByPid(String pid);



    List<Bill> findAll(@Param("productName") String productName,@Param("provider_id") Integer provider_id,@Param("isPayment") Integer isPayment);

    void save(Bill bill);

    @Select("select * from t_bill where id=#{id}")
    Bill view(String id);

    @Delete("delete  from t_bill where id=#{id}")
    void delete(String id);

    void update(Bill bill);
}
