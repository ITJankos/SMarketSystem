package com.houpu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import com.houpu.domain.PageBean;
import com.houpu.domain.Provider;
import com.houpu.domain.User;
import com.houpu.mapper.BilMapper;
import com.houpu.mapper.ProviderMapper;
import com.houpu.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderMapper providerMapper;
    @Autowired
    private BilMapper bilMapper;
    @Override
    public PageInfo<Provider> findAllByPAge(int num, int size, String proCode, String proName) {
       //设置分页数据
        PageHelper.startPage(num,size);
        List<Provider> providerList = providerMapper.findAll(proCode,proName);
        //用PageInfo对结果进行包装
        PageInfo<Provider> pageInfo = new PageInfo(providerList);
        return pageInfo;


    }

    @Override
    public void add(Provider provider) {
        providerMapper.save(provider);
    }

    @Override
    public Provider findById(String id) {
        return providerMapper.findById(id);
    }

    @Override
    public void update(Provider provider) {
        providerMapper.update(provider);
    }

    @Override
    public void delete(String id) {
         //线删除订单表
        bilMapper.deleteByPid(id);
        providerMapper.delete(id);
    }

    @Override
    public List<Provider> findAllProvider() {
        return providerMapper.findAllProvider();
    }

    @Override
    public void saveList(List<Provider> providerList) {
        for (Provider provider:providerList){
            this.add(provider);
        }
    }


}
