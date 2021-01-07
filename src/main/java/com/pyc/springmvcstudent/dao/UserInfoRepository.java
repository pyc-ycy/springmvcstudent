//IntelliJ IDEA
//springmvcstudent
//UserInfoRepository
//2021/1/7
// Author:御承扬
//E-mail:2923616405@qq.com


package com.pyc.springmvcstudent.dao;

import com.pyc.springmvcstudent.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
