package com.jpa.study.pojo;

import lombok.Getter;

@Getter
public enum OrderStatus implements LegacyCommonType{

    DEPOSIT_STANBY("입금대기","DS"),
    PAYMENT_CONFIRM("결제확인","PC"),
    DELIVERY_PREPARE("배송준비","DP"),
    DELIVERY_COMPLETE("배송완료","DC"),
    BOX_DELIVERY("배송중","BD"),
    REFUND_WAIT("환불준비","RW"),
    REFUND_COMPLETE("환불완료","RC");

    private String desc;
    private String legacyCode;

    OrderStatus(String desc, String legacyCode){
        this.desc = desc;
        this.legacyCode = legacyCode;
    }

}
