package com.ruoyi.system.controller;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.domain.RequestDTO;
import com.ruoyi.system.api.domain.SysUser;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *  参数控制器
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-10-14
 */
@RestController
@RequestMapping("/params")
public class ParamsController {

    @PostMapping("/hi")
    @ApiOperation(value = "测试")
    public R<SysUser> hi(@RequestBody RequestDTO<SysUser> requestDTO) {
        System.out.println(requestDTO.getHeader());
        return R.ok(requestDTO.getBody());
    }

    @GetMapping("/queryParamFile/{code}/{tableEnName}")
    @ApiOperation(value = "查询参数文件是否更新")
    public R<Boolean> queryParams(@NotBlank @PathVariable String code,
                                  @NotBlank @PathVariable String tableEnName) {
        //根据Code与英文表名查询参数更新标识
        return R.ok(true);
    }



}
