package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.entity.CComprobanteContEnc;
import com.apirest.financiero.models.entity.CComprobanteContEncPK;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICComprobanteContEncService {

    public List<CComprobanteContEnc> findAll();

    public Page<CComprobanteContEnc> findAllPage(Pageable pageable);

    public CComprobanteContEnc findById(CComprobanteContEncPK cComprobanteContEncPK);
	
	public CComprobanteContEnc save(CComprobanteContEnc cComprobanteContEnc);

}