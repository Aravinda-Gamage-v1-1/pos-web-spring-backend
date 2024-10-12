package lk.ijse.backend.customeObj;

import java.io.Serializable;

public class CustomerErrorResponse implements CustomerResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
