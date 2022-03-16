package com.jack.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum SexEnum {

    MALE(1, "男"),
    FEMALE(2, "女");

    private Integer codeValue;

    private String codeText;

    public static SexEnum getInstance(Integer type) {
        SexEnum[] values = SexEnum.values();
        for (SexEnum value : values) {
            if (type.intValue() == value.getCodeValue().intValue()) {
                return value;
            }
        }
        return null;
    }

    public static SexEnum getInstance(String codeText) {
        SexEnum[] values = SexEnum.values();
        for (SexEnum value : values) {
            if (Objects.equals(codeText, value.getCodeText())) {
                return value;
            }
        }
        return null;
    }

    public static String getCodeText(Integer codeValue) {
        SexEnum[] values = values();
        for (SexEnum value : values) {
            if (value.getCodeValue().equals(codeValue)) {
                return value.getCodeText();
            }
        }
        return StringUtils.EMPTY;
    }

    public static Integer parse(String codeText) {
        SexEnum[] values = values();
        for (SexEnum value : values) {
            if (value.getCodeText().equals(StringUtils.trim(codeText))) {
                return value.getCodeValue();
            }
        }
        return null;
    }
}
