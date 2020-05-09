package com.houpu.service;

import com.github.pagehelper.PageInfo;
import com.houpu.domain.PageBean;
import com.houpu.domain.Provider;

import java.util.List;

public interface ProviderService {
    /*PageInfo<Provider> findAllByPAge(int num,int size);*/

    PageInfo<Provider> findAllByPAge(int num, int size, String proCode, String proName);

    void add(Provider provider);

    Provider findById(String id);

    void update(Provider provider);

    void delete(String id);

    List<Provider> findAllProvider();

    void saveList(List<Provider> providerList);
}
