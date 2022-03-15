package com.jack.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum YesOrNoEnum {

    NO(0, "否"),
    YES(1, "是");

    private Integer codeValue;

    private String codeText;

    public static YesOrNoEnum getInstance(Integer type) {
        YesOrNoEnum[] values = YesOrNoEnum.values();
        for (YesOrNoEnum value : values) {
            if (type.intValue() == value.getCodeValue().intValue()) {
                return value;
            }
        }
        return null;
    }

    public static YesOrNoEnum getInstance(String codeText) {
        YesOrNoEnum[] values = YesOrNoEnum.values();
        for (YesOrNoEnum value : values) {
            if (Objects.equals(codeText, value.getCodeText())) {
                return value;
            }
        }
        return null;
    }

    public static String getCodeText(Integer codeValue) {
        YesOrNoEnum[] values = values();
        for (YesOrNoEnum value : values) {
            if (value.getCodeValue().equals(codeValue)) {
                return value.getCodeText();
            }
        }
        return StringUtils.EMPTY;
    }

    public static Integer parse(String codeText) {
        YesOrNoEnum[] values = values();
        for (YesOrNoEnum value : values) {
            if (value.getCodeText().equals(StringUtils.trim(codeText))) {
                return value.getCodeValue();
            }
        }
        return null;
    }
}
