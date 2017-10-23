package snippets.jee.service.impl;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import snippets.jee.dto.UserLoginDTO;
import snippets.jee.entity.LoginLog;
import snippets.jee.entity.User;
import snippets.jee.persistence.LoginLogDAO;
import snippets.jee.persistence.UserDAO;
import snippets.jee.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private LoginLogDAO loginLogDAO;

    @Override
    public boolean login (UserLoginDTO userDTO) {
        boolean flag = false;
        User temp = userDAO.findByUsername(userDTO.getUsername());
        if (temp != null) {
            String md5 = DigestUtils.md5Hex(userDTO.getPassword());
            flag = temp.getPassword().equals(md5);
            if (flag) {
                userDTO.setId(temp.getId());
                userDTO.setRealname(temp.getRealname());
                LoginLog loginLog = new LoginLog();
                loginLog.setUser(temp);
                loginLog.setIpAddress(userDTO.getIpAddress());
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
            user.setAdmin(false);
            return userDAO.save(user) != null;
        }
        return false;
    }

    @Override
    public boolean checkUnique(String username) {
        return userDAO.findByUsername(username) == null;
    }
}
