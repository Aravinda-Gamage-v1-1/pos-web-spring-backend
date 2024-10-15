package lk.ijse.backend.customeObj.impl;

import lk.ijse.backend.customeObj.OrderResponse;

import java.io.Serializable;

public class OrderErrorResponse implements OrderResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
