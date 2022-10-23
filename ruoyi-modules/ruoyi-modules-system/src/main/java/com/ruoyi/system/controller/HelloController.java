package com.ruoyi.system.controller;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.domain.RequestDTO;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.domain.SysMenu;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-10-14
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @PostMapping("/hi")
    public R<SysUser> hi(@RequestBody RequestDTO<SysUser> requestDTO) {
        System.out.println(requestDTO.getHeader());
        return R.ok(requestDTO.getBody());
    }

}
