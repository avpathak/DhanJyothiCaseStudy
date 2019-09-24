package com.dhanjyothi.dao.impl;

import java.util.Base64;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.dhanjyothi.dao.LoginDao;
import com.dhanjyothi.model.User;


@Repository("LoginDao")
public class LoginDaoImpl implements LoginDao {
	
	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public int validateUser(User user) {
		int valid = 0;
		System.out.println("Inside Validate Customer Dao");
		logger.info("Inside Validate Customer Dao");
		logger.info(user.getUserName() + "-" + user.getPassword());
		
		List<User> list = hibernateTemplate.loadAll(User.class);
		System.out.println("List Size" + list.size());

		for (User c : list) {
			logger.info(user.getUserName() + "-" + user.getPassword());
			logger.info(c.getUserName() + "-" + c.getPassword());

			Base64.Decoder decoder = Base64.getDecoder();
			byte[] decodedByteArray = decoder.decode(user.getPassword());
			logger.info("New Password" + new String(decodedByteArray));
			if (user.getUserName().equals(c.getUserName())
					&& new String(decodedByteArray).equals(c.getPassword())) {

				if (user.getUserName().equals("admin") && new String(decodedByteArray).equals("admin")) {
					logger.info("Validate Data");
					valid = 0;
					return valid;
				}
				else {
					valid = 1;
					return valid;
				}
			}
			
		}
		return valid;
	}
}