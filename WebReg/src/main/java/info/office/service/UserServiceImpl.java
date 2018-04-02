//package info.office.service;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import info.office.dao.UserDAO;
//import info.office.entity.User;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	UserDAO userDAO;
//	
//	@Override
//	@Transactional
//	public void saveUser(User user) {
//		userDAO.save(user);
//	}
//
//}
