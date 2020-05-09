package com.houpu.service;

import com.github.pagehelper.PageInfo;
import com.houpu.domain.Bill;

public interface BillService {


    PageInfo<Bill> findAll(Integer pageNum, Integer pageSize, String productName, Integer provider_id, Integer isPayment);

    void add(Bill bill);

    Bill view(String id);

    void delete(String id);

    void update(Bill bill);
}
