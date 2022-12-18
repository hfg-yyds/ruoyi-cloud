package com.ruoyi.common.log.filter;

import com.alibaba.fastjson2.filter.SimplePropertyPreFilter;

/**
 * 排除JSON敏感属性
 *
 * @author ruoyi
 */
public class PropertyPreExcludeFilter extends SimplePropertyPreFilter {
    /**
     * 私有化构造器
     */
    private PropertyPreExcludeFilter() {
    }

    /**
     * 得到Instance
     * @return PropertyPreExcludeFilter
     */
    public static PropertyPreExcludeFilter getInstance() {
        return new PropertyPreExcludeFilter();
    }

    /**
     * 排除Json敏感数据
     * @param filters filters
     * @return PropertyPreExcludeFilter
     */
    public PropertyPreExcludeFilter addExcludes(String... filters) {
        for (String filter : filters) {
            this.getExcludes().add(filter);
        }
        return this;
    }

}
