//IntelliJ IDEA
//springmvcstudent
//UserInfoRepository
//2021/1/7
// Author:御承扬
//E-mail:2923616405@qq.com


package com.pyc.springmvcstudent.dao;

import com.pyc.springmvcstudent.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findAllByStuID(String stuID);

    @Modifying
    @Transactional
    @Query("update UserInfo ui set ui.online=?1 where ui.stuID=?2")
    int setOnlineByStuID(Boolean online, String stuId);
}
