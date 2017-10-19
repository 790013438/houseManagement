package snippets.jee.persistence.impl;

import org.springframework.stereotype.Repository;

import snippets.jee.entity.LoginLog;
import snippets.jee.persistence.LoginLogDAO;

@Repository
public class LoginLogDAOImpl extends BaseDAOAdapter<LoginLog, Integer> implements LoginLogDAO {
}
