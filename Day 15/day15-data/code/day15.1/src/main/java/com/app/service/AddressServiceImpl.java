package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.pojos.Address;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	// dep : adr dao layer i/f
	@Autowired // by type : Field level DI
	private AddressDao addressDao;

	@Override
	public Address getAddressDetails(long adrId) {
		// TODO Auto-generated method stub
		return addressDao.findById(adrId)
				.orElseThrow(() ->
				new ResourceNotFoundException("Address not yet assigned!!!!"));
	}

}
