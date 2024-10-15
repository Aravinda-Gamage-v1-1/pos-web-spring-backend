package lk.ijse.backend.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailPrimaryKey implements Serializable {
    private String orderId;
    private String itemId;
}
