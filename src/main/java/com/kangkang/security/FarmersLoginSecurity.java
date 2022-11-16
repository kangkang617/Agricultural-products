package com.kangkang.security;

/**
 * ClassName:FarmersLoginSecurity
 * Package:com.kangkang.security
 * Description:
 *
 * @date:2022/4/15 15:35
 * @author:kangkang
 */
/*
@Service
public class FarmersLoginSecurity implements UserDetailsService {
    @Autowired
    private PasswordEncoder pw;

    @Resource
    private BaseMapper baseMapper;
    @Resource
    private FarmersMapper farmersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Farmers byPhone = farmersMapper.selectByPhone(username);
        if (byPhone == null){
            throw new UsernameNotFoundException("用户名未找到");
        }
//        boolean matches = pw.matches(password, byPhone.getPassword());

        String password = pw.encode(byPhone.getPassword());

        return new User
                (username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));



    }

}
*/
