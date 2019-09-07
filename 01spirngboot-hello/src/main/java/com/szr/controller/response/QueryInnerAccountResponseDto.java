package com.szr.controller.response;

import com.szr.controller.response.inner.Sub;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 内部账户查询响应实体类
 * @author liuy
 * @time 2019年7月16日 20:19:31
 */
@Getter
@Setter
public class QueryInnerAccountResponseDto {

    @Valid
    @NotNull(message = "子账号信息数组为空")
    private List<Sub> SUB_ARRAY;  //子账号信息数组
}
