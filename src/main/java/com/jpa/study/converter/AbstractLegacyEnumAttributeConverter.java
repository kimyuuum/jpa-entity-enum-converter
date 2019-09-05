package com.jpa.study.converter;

import com.jpa.study.pojo.LegacyCommonType;
import lombok.Getter;

import javax.persistence.AttributeConverter;

@Getter
public class AbstractLegacyEnumAttributeConverter<E extends Enum<E> & LegacyCommonType> implements AttributeConverter<E, String> {

    // 대상 Enum 클래스의 link Class 객체
    private Class<E> targetEnumClass;

    /* nullable = false이면 변환할 값이 null로 들어왔을 때 예외가 발생한다.
     * nullable = true면 변환할 값이 null일때 예외 없이 실행하며 legacy code로 변환시에는 빈 문자열로 변환한다.
     */
    private boolean nullable;

    // nullable = false 일 때 출력할 오류 메시지에서 enum에 대한 설명을 위해 Enum의 설명적 이름을 받는다.
    private String enumName;

    public AbstractLegacyEnumAttributeConverter(Class<E> targetEnumClass, boolean nullable, String enumName) {
        this.targetEnumClass = targetEnumClass;
        this.nullable = nullable;
        this.enumName = enumName;
    }

    //enum -> db data
    @Override
    public String convertToDatabaseColumn(E attribute) {
        if (!nullable && attribute == null) {
            throw new IllegalArgumentException("NULL로 저장할 수 없습니다.");
        }
        return LegacyEnumValueConvertUtils.toLegacyCode(attribute);
    }

    //db data -> enum
    @Override
    public E convertToEntityAttribute(String dbData) {
        return LegacyEnumValueConvertUtils.ofLegacyCode(targetEnumClass, dbData);
    }

}
