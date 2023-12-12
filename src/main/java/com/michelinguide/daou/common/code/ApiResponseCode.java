package com.michelinguide.daou.common.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiResponseCode {
    // 2xx : SUCCESS CODE
    CREATE_SUCCESS("S000", "데이터 저장을 성공하였습니다."),
    READ_SUCCESS("S001", "데이터 불러오기를 성공하였습니다."),
    UPDATE_SUCCESS("S002", "데이터 수정을 성공하였습니다."),
    DELETE_SUCCESS("S003", "데이터 삭제를 성공하였습니다."),

    // 4xx : FAIL CODE
    // 401 (UnAuthorization)
    TOKEN_FAIL("U000", "테스트용입니다."),

    // 500 (Internal Server Exception)
    SERVER_FAIL("I000" ,"서버에서 발생한 오류입니다.");

    private final String code;
    private final String message;
}
