package com.ruoyi.common.core.xss;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ruoyi.common.core.utils.StringUtils;

/**
 * 自定义xss校验注解实现
 *
 * @author ruoyi
 */
public class XssValidator implements ConstraintValidator<Xss, String> {

    /**
     * Http模式匹配
     */
    private static final String HTML_PATTERN = "<(\\S*?)[^>]*>.*?|<.*? />";

    /**
     * 验证是否有效
     * @param value 待验证字符串
     * @param constraintValidatorContext constraintValidatorContext
     * @return boolean
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(value)) {
            return true;
        }
        return !containsHtml(value);
    }

    /**
     * 是否包含Html
     * @param value value值
     * @return boolean
     */
    public static boolean containsHtml(String value) {
        Pattern pattern = Pattern.compile(HTML_PATTERN);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

}