package com.houpu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.houpu.domain.Bill;
import com.houpu.mapper.BilMapper;
import com.houpu.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BilMapper billMapper;
    @Override
    public PageInfo<Bill> findAll(Integer pageNum, Integer pageSize,String productName, Integer provider_id, Integer isPayment) {
        //设置分页条件
        PageHelper.startPage(pageNum,pageSize);
        //进行分页查询

       List<Bill> billList = billMapper.findAll(productName,provider_id,isPayment);
        return new PageInfo<>(billList);
    }

    @Override
    public void add(Bill bill) {
        billMapper.save(bill);
    }

    @Override
    public Bill view(String id) {
        return billMapper.view(id);
    }

    @Override
    public void delete(String id) {
        billMapper.delete(id);
    }

    @Override
    public void update(Bill bill) {
        billMapper.update(bill);
    }
}
