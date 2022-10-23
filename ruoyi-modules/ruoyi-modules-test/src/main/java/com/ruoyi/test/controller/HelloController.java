package com.ruoyi.test.controller;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.domain.Header;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.domain.RequestDTO;
import com.ruoyi.test.domain.PersonInfo;
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
 * @date: 2022-10-13
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    /**
     *
     * @param requestDTO
     * @return
     */
    @PostMapping("/hello")
    public R<?> hello(@RequestBody RequestDTO<PersonInfo> requestDTO) {
        PersonInfo body = requestDTO.getBody();
        System.out.println(body);
        Header header = requestDTO.getHeader();
        System.out.println(JSON.toJSONString(header));
        return R.ok("哈哈哈");
    }

}
