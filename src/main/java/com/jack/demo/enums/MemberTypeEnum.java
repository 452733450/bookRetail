package com.jack.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum MemberTypeEnum {

    COPER(1, "铜牌会员"),
    SILVER(2, "银牌会员"),
    GOLD(3,"金牌会员"),
    ;
    private Integer codeValue;

    private String codeText;

    public static MemberTypeEnum getInstance(Integer type) {
        MemberTypeEnum[] values = MemberTypeEnum.values();
        for (MemberTypeEnum value : values) {
            if (type.intValue() == value.getCodeValue().intValue()) {
                return value;
            }
        }
        return null;
    }

    public static MemberTypeEnum getInstance(String codeText) {
        MemberTypeEnum[] values = MemberTypeEnum.values();
        for (MemberTypeEnum value : values) {
            if (Objects.equals(codeText, value.getCodeText())) {
                return value;
            }
        }
        return null;
    }

    public static String getCodeText(Integer codeValue) {
        MemberTypeEnum[] values = values();
        for (MemberTypeEnum value : values) {
            if (value.getCodeValue().equals(codeValue)) {
                return value.getCodeText();
            }
        }
        return StringUtils.EMPTY;
    }

    public static Integer parse(String codeText) {
        MemberTypeEnum[] values = values();
        for (MemberTypeEnum value : values) {
            if (value.getCodeText().equals(StringUtils.trim(codeText))) {
                return value.getCodeValue();
            }
        }
        return null;
    }
}
