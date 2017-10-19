package snippets.jee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import snippets.jee.entity.User;
import snippets.jee.persistence.LoginLogDAO;
import snippets.jee.persistence.UserDAO;
import snippets.jee.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @SuppressWarnings("unused")
    @Autowired
    private UserDAO userDAO;

    @SuppressWarnings("unused")
    @Autowired
    private LoginLogDAO loginLogDAO;

    @Override
    public boolean login (User user) {
        boolean flag = false;
        User temp = userDAO.findByUsername(user.getUsername());
        if (temp != null) {
            String md5 = DigestUtils.md5Hex(user.getPassword());
            flag = temp.getPassword().equals(md5);
            if (flag) {
                LoginLog.loginLog = new LoginLog();
                loginLog.setUser(temp);
                loginLog.setIpAddress("211.135.62.90");
                loginLog.setLogDate(new Date());
                loginLogDAO.save(loginLog);
            }
        }
        return flag;
    }

    @Override
    public boolean register (User user) {
        User temp = userDAO.findByUsername(user.getUsername());
        if (temp == null) {
            String md5 = DigestUtils.md5Hex(user.getPassword());
            user.setPassword(md5);
            return userDAO.save(user) != null;
        }
        return false;
    }
}
