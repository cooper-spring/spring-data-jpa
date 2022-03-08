package com.cooper.springdatajpa.ui.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApiResponse<T> {

    private final T data;

    public static <T> ApiResponse<T> create (T data) {
        return new ApiResponse<>(data);
    }
}
