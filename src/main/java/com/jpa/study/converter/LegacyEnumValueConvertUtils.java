package com.jpa.study.converter;

import com.jpa.study.exception.NotFoundException;
import com.jpa.study.pojo.LegacyCommonType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.EnumSet;

/*
 * {@link legacyCommonType} enum을 String과 상호 변환하는 유틸리티 클래스
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LegacyEnumValueConvertUtils {
    public static <T extends Enum<T> & LegacyCommonType> T ofLegacyCode(Class<T> enumClass,
                                                                        String legacyCode){
        if(!StringUtils.hasText(legacyCode)){
            return null;
        }

        return EnumSet.allOf(enumClass)
                .stream()
                .filter(v -> v.getLegacyCode().equals(legacyCode))
                .findAny()
                .orElseThrow(()-> new NotFoundException("Can Not found Enum / Legacy Code"));
    }

        /**
         * enum에 없는 값이면 ""이 들어가서 converter 추가를 함.
         */
        public static <T extends Enum<T> & LegacyCommonType> String toLegacyCode(T enumValue){

            if( enumValue == null){
                return "";
            }

            return enumValue.getLegacyCode();
    }
}
