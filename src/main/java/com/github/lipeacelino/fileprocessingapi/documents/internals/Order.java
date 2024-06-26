package com.github.lipeacelino.fileprocessingapi.documents.internals;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Order {

    @Indexed(name="orderIdIndex")
    private Integer orderId;

    private BigDecimal total;

    private LocalDate date;

    private List<Product> products;

}
